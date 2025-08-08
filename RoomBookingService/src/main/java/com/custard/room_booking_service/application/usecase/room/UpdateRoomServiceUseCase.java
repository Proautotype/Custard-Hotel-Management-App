package com.custard.room_booking_service.application.usecase.room;

import com.custard.room_booking_service.application.command.room.UpdateRoomCommand;
import com.custard.room_booking_service.domain.model.Room;

import java.util.UUID;

public interface UpdateRoomServiceUseCase {
    Room execute(UUID roomId, UpdateRoomCommand command);
}
