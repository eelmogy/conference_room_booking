package com.example.conference_room_booking.services;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.conference_room_booking.dtos.BookingRequest;
import com.example.conference_room_booking.exceptions.NoAvailableRoomException;
import com.example.conference_room_booking.models.Booking;
import com.example.conference_room_booking.models.ConferenceRoom;
import com.example.conference_room_booking.repositories.BookingRepository;
import com.example.conference_room_booking.repositories.ConferenceRoomRepository;
import com.example.conference_room_booking.validations.BookingValidator;

@Service
public class BookingService {

    @Autowired
    private ConferenceRoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingValidator bookingValidator;

    public Booking bookRoom(BookingRequest bookingRequest) {
        List<ConferenceRoom> rooms = roomRepository.findAll();
        bookingValidator.validateBooking(bookingRequest, rooms);

        rooms.sort(Comparator.comparingInt(ConferenceRoom::getCapacity));

        for (ConferenceRoom room : rooms) {
            if (room.getCapacity() >= bookingRequest.getNumberOfPeople()) {
                if (isRoomAvailable(room.getName(), bookingRequest.getStartTime(), bookingRequest.getEndTime())) {
                    Booking booking = new Booking();
                    booking.setConferenceRoomName(room.getName());
                    booking.setStartTime(bookingRequest.getStartTime());
                    booking.setEndTime(bookingRequest.getEndTime());
                    booking.setNumberOfPeople(bookingRequest.getNumberOfPeople());
                    return bookingRepository.save(booking);
                }
            }
        }
        throw new NoAvailableRoomException("No available room for the given time and number of people");
    }

    private boolean isRoomAvailable(String roomName, LocalTime startTime, LocalTime endTime) {
        List<Booking> bookings = bookingRepository.findConflictingBookings(roomName, startTime, endTime);
        return bookings.isEmpty();
    }

    public List<ConferenceRoom> getAvailableRooms(LocalTime startTime, LocalTime endTime) {
        List<ConferenceRoom> rooms = roomRepository.findAll();
        return rooms.stream()
                .filter(room -> isRoomAvailable(room.getName(), startTime, endTime))
                .collect(Collectors.toList());
    }
}

