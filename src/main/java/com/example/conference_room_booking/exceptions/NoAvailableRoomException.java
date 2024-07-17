package com.example.conference_room_booking.exceptions;

public class NoAvailableRoomException extends RuntimeException {
    public NoAvailableRoomException(String message) {
        super(message);
    }
}
