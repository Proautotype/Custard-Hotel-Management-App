package com.custard.room_booking_service.application.usecase.booking;

import com.custard.room_booking_service.application.command.booking.CreateBookingCommand;

public interface CreateBookingServiceUseCase {
    void execute(CreateBookingCommand command);
}
