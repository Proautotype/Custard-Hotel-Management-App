package com.custard.hotelmgmt.domain.service;

import com.custard.hotelmgmt.domain.model.Booking;

public class BookingValidator {
    private BookingValidator(){}
    public static void validate(Booking booking){
        if(booking.getCustomerName().isBlank()){
            throw new IllegalStateException("Customer name cannot be empty");
        }
        if(booking.getRoomId() == null){
            throw new IllegalStateException("Please select room id");
        }
    }
}
