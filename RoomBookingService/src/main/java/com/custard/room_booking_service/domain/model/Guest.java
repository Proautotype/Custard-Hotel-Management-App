package com.custard.room_booking_service.domain.model;

import com.custard.room_booking_service.domain.service.GuestValidator;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private static final Logger logger = LoggerFactory.getLogger(Guest.class);

    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String idNumber;
    private LocalDate dateOfBirth;

    public static Guest create(String firstName, String lastName, String phone, String email, String idNumber, LocalDate dateOfBirth){
        logger.info("Create new Guest");
        Guest appGuest = Guest.builder()
                .firstName(firstName).lastName(lastName)
                .phone(phone).email(email).idNumber(idNumber)
                .dateOfBirth(dateOfBirth)
                .build();
        GuestValidator.validate(appGuest);
        return appGuest;
    }

}
