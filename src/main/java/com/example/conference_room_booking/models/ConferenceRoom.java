package com.example.conference_room_booking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ConferenceRoom {
    @Id
    private String name;
    private int capacity;

    public ConferenceRoom() {}

    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}


