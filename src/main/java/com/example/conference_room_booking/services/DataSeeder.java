package com.example.conference_room_booking.services;

import com.example.conference_room_booking.models.ConferenceRoom;
import com.example.conference_room_booking.repositories.ConferenceRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder {

    @Autowired
    private ConferenceRoomRepository roomRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedConferenceRooms();
    }

    private void seedConferenceRooms() {
        if (roomRepository.count() == 0) {
            List<ConferenceRoom> rooms = Arrays.asList(
                new ConferenceRoom("Beauty", 10),
                new ConferenceRoom("Amaze", 5),
                new ConferenceRoom("Inspire", 15),
                new ConferenceRoom("Strive", 20)
            );
            roomRepository.saveAll(rooms);
        }
    }
}
