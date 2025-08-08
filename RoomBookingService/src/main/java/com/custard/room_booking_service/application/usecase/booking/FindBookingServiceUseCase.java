package com.custard.room_booking_service.application.usecase.booking;

import java.util.UUID;

public interface FindBookingServiceUseCase {
    void execute(UUID roomId, UUID guestId);
}
