package com.custard.hotelmgmt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
	info = @Info(
		title = "Room and Booking APIs",
		version = "1",
		description = "Contains API for managing room and booking for the custard hotel management application"
	)
)
@SpringBootApplication
public class RoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingApplication.class, args);
	}

}
