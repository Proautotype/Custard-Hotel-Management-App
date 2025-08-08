package com.custard.room_booking_service.domain.service;

import com.custard.room_booking_service.domain.model.Booking;
import io.netty.util.internal.StringUtil;

public class BookingValidator {
    private BookingValidator(){}
    public static void validate(Booking booking){
        if(!StringUtil.isNullOrEmpty(booking.getGuestId().toString())){
            throw new IllegalStateException("Customer name cannot be empty");
        }
        if(booking.getRoomId() == null){
            throw new IllegalStateException("Please select room id");
        }
    }
}
