package com.custard.room_booking_service.application.usecase.guest;

import com.custard.room_booking_service.application.command.room.DeleteRoomCommand;


public interface DeleteGuestServiceUseCase {
    boolean execute(DeleteRoomCommand command);
}
