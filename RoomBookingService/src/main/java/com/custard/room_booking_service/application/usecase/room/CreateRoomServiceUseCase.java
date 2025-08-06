package com.custard.room_booking_service.application.usecase.room;

import com.custard.room_booking_service.application.command.CreateRoomCommand;
import com.custard.room_booking_service.domain.model.Room;

public interface CreateRoomServiceUseCase {
    Room execute(CreateRoomCommand command);
}
