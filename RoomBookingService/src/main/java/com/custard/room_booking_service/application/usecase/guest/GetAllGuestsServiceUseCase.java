package com.custard.room_booking_service.application.usecase.guest;

import com.custard.room_booking_service.domain.model.Guest;

import java.util.List;

public interface GetAllGuestsServiceUseCase {
    List<Guest> execute();
}
