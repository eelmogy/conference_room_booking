// package com.example.conference_room_booking;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.time.LocalTime;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.ActiveProfiles;

// import com.example.conference_room_booking.dtos.BookingRequest;
// import com.example.conference_room_booking.exceptions.InvalidBookingException;
// import com.example.conference_room_booking.models.Booking;
// import com.example.conference_room_booking.models.ConferenceRoom;
// import com.example.conference_room_booking.services.BookingService;

// @ActiveProfiles("test")
// public class BookingServiceTest {

//     @Autowired
//     private BookingService bookingService;

//     @Test
//     public void testBookRoom() {
//         BookingRequest request = new BookingRequest();
//         request.setStartTime(LocalTime.of(10, 0));
//         request.setEndTime(LocalTime.of(11, 0));
//         request.setNumberOfPeople(5);
        
//         Booking booking = bookingService.bookRoom(request);
//         assertNotNull(booking);
//         assertEquals("Amaze", booking.getConferenceRoomName());
//     }

//     @Test
//     public void testGetAvailableRooms() {
//         List<ConferenceRoom> availableRooms = bookingService.getAvailableRooms(LocalTime.of(10, 0), LocalTime.of(11, 0));
//         assertFalse(availableRooms.isEmpty());
//     }

//     @Test
//     public void testInvalidBookingDuringMaintenance() {
//         BookingRequest request = new BookingRequest();
//         request.setStartTime(LocalTime.of(9, 0));
//         request.setEndTime(LocalTime.of(9, 30));
//         request.setNumberOfPeople(5);
        
//         assertThrows(InvalidBookingException.class, () -> bookingService.bookRoom(request));
//     }

//     @Test
//     public void testInvalidNumberOfPeople() {
//         BookingRequest request = new BookingRequest();
//         request.setStartTime(LocalTime.of(10, 0));
//         request.setEndTime(LocalTime.of(11, 0));
//         request.setNumberOfPeople(25);
        
//         assertThrows(InvalidBookingException.class, () -> bookingService.bookRoom(request));
//     }

//     @Test
//     public void testGetAvailableRoomsDuringMaintenance() {
//         List<ConferenceRoom> availableRooms = bookingService.getAvailableRooms(LocalTime.of(9, 0), LocalTime.of(9, 30));
//         assertTrue(availableRooms.isEmpty());
//     }

//     @Test
//     public void testGetAvailableRoomsWithNoConflict() {
//         bookingService.bookRoom(new BookingRequest(LocalTime.of(10, 0), LocalTime.of(11, 0), 5));
//         List<ConferenceRoom> availableRooms = bookingService.getAvailableRooms(LocalTime.of(11, 0), LocalTime.of(12, 0));
//         assertFalse(availableRooms.isEmpty());
//     }
// }

