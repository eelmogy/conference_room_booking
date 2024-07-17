package com.example.conference_room_booking.dtos;

import java.time.LocalTime;

public class BookingRequest {
    private LocalTime startTime;
    private LocalTime endTime;
    private int numberOfPeople;

    public BookingRequest() {}

    public BookingRequest(LocalTime startTime, LocalTime endTime, int numberOfPeople) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfPeople = numberOfPeople;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
