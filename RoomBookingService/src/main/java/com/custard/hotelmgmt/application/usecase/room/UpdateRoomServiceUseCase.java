package com.custard.hotelmgmt.application.usecase.room;

import com.custard.hotelmgmt.application.command.UpdateRoomCommand;
import com.custard.hotelmgmt.domain.model.Room;

import java.util.UUID;

public interface UpdateRoomServiceUseCase {
    Room execute(UUID roomId, UpdateRoomCommand command);
}
