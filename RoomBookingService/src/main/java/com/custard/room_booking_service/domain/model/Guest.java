package com.custard.room_booking_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public String getFullname() {
        return firstName + " " + lastName;
    }

}
