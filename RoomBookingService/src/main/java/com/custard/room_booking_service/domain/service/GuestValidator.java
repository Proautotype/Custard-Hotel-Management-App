package com.custard.room_booking_service.domain.service;

import com.custard.room_booking_service.domain.model.Guest;

public class GuestValidator {

    private GuestValidator(){}

    public static void validate(
            String firstName, String lastName,
            String phone, String email
    ){
        if(firstName.isBlank()){
            throw new IllegalArgumentException("First name should be provided");
        }
        if(lastName.isBlank()){
            throw new IllegalArgumentException("Last name should be provided");
        }
        if(phone.isBlank()){
            throw new IllegalArgumentException("Phone should be provided");
        }
        if(email.isBlank()){
            throw new IllegalArgumentException("Email should be provided");
        }
    }

    public static void validate(Guest guest){
        validate(guest.getFirstName(), guest.getLastName(),
                guest.getPhone(), guest.getEmail());
    }

}
