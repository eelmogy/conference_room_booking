package com.example.conference_room_booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conference_room_booking.models.ConferenceRoom;

@Repository
public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoom, String> {
}
