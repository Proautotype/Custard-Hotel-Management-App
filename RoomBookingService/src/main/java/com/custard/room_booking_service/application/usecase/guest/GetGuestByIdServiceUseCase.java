package com.custard.room_booking_service.application.usecase.guest;

import com.custard.room_booking_service.domain.model.Guest;

import java.util.UUID;

public interface GetGuestByIdServiceUseCase {
     Guest execute(UUID id);
}
