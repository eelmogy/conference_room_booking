package com.example.conference_room_booking.validations;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.conference_room_booking.dtos.BookingRequest;
import com.example.conference_room_booking.exceptions.InvalidBookingException;
import com.example.conference_room_booking.models.ConferenceRoom;

@Component
public class BookingValidator {

    public void validateBooking(BookingRequest bookingRequest, List<ConferenceRoom> rooms) {
        if (bookingRequest.getNumberOfPeople() < 1 || bookingRequest.getNumberOfPeople() > getMaxCapacity(rooms)) {
            throw new InvalidBookingException("Invalid number of people for booking");
        }

        if (isMaintenanceTime(bookingRequest.getStartTime(), bookingRequest.getEndTime())) {
            throw new InvalidBookingException("Cannot book during maintenance time");
        }

        if (bookingRequest.getStartTime().isBefore(LocalTime.now())) {
            throw new InvalidBookingException("Cannot book for past times");
        }
    }

    private boolean isMaintenanceTime(LocalTime startTime, LocalTime endTime) {
        List<LocalTime> maintenanceStartTimes = Arrays.asList(LocalTime.of(9, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        List<LocalTime> maintenanceEndTimes = Arrays.asList(LocalTime.of(9, 15), LocalTime.of(13, 15), LocalTime.of(17, 15));

        for (int i = 0; i < maintenanceStartTimes.size(); i++) {
            if (startTime.isBefore(maintenanceEndTimes.get(i)) && endTime.isAfter(maintenanceStartTimes.get(i))) {
                return true;
            }
        }

        return false;
    }

    private int getMaxCapacity(List<ConferenceRoom> rooms) {
        return rooms.stream().mapToInt(ConferenceRoom::getCapacity).max().orElse(0);
    }
}
