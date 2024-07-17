package com.example.conference_room_booking.repositories;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.conference_room_booking.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.conferenceRoomName = :conferenceRoomName AND " +
         "(b.startTime BETWEEN :startTime AND :endTime OR b.endTime BETWEEN :startTime AND :endTime)")
    List<Booking> findConflictingBookings(@Param("conferenceRoomName") String conferenceRoomName, 
                                   @Param("startTime") LocalTime startTime, 
                                   @Param("endTime") LocalTime endTime);
}


