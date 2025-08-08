package com.custard.room_booking_service.application.command.guest;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpdateGuestCommand {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String idNumber;
    private LocalDate dateOfBirth;
}
