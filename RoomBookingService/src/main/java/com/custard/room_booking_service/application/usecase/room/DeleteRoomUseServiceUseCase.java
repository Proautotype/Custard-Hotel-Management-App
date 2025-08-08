package com.custard.room_booking_service.application.usecase.room;

import com.custard.room_booking_service.application.command.room.DeleteRoomCommand;

public interface DeleteRoomUseServiceUseCase {
    Boolean execute(DeleteRoomCommand deleteRoomCommand);
}
