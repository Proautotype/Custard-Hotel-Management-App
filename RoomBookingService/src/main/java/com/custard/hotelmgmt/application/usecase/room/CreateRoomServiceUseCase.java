package com.custard.hotelmgmt.application.usecase.room;

import com.custard.hotelmgmt.application.command.CreateRoomCommand;
import com.custard.hotelmgmt.domain.model.Room;

public interface CreateRoomServiceUseCase {
    Room execute(CreateRoomCommand command);
}
