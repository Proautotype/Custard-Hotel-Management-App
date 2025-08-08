package com.custard.room_booking_service.application.usecase.booking;

import com.custard.room_booking_service.application.command.booking.UpdateBookingCommand;

import java.util.UUID;

public interface UpdateBookingServiceUseCase {
    void execute(UUID id, UpdateBookingCommand command);
}
