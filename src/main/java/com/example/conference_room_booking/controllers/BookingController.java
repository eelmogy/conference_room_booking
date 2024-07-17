package com.example.conference_room_booking.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.conference_room_booking.dtos.BookingRequest;
import com.example.conference_room_booking.models.Booking;
import com.example.conference_room_booking.models.ConferenceRoom;
import com.example.conference_room_booking.services.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookRoom(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.bookRoom(bookingRequest);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ConferenceRoom>> getAvailableRooms(@RequestParam LocalTime startTime, @RequestParam LocalTime endTime) {
        List<ConferenceRoom> availableRooms = bookingService.getAvailableRooms(startTime, endTime);
        return ResponseEntity.ok(availableRooms);
    }
}
