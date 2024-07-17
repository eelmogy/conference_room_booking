package com.example.conference_room_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.example.conference_room_booking")
@EnableJpaRepositories(basePackages = "com.example.conference_room_booking.repositories")
public class ConferenceRoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceRoomBookingApplication.class, args);
	}

}
