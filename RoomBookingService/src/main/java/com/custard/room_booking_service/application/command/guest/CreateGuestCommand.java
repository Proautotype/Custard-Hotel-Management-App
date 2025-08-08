package com.custard.room_booking_service.application.command.guest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateGuestCommand {
    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private String phone;
    @Email
    private String email;
    private String idNumber;
    @Future
    private LocalDate dateOfBirth;
}
