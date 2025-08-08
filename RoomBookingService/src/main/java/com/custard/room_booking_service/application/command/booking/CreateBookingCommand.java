package com.custard.room_booking_service.application.command.booking;

import com.custard.room_booking_service.domain.vo.DateRange;

public class CreateBookingCommand {
    private String customerName;
    private DateRange period;
}
