package com.custard.hotelmgmt.application.usecase.room;

import com.custard.hotelmgmt.application.command.DeleteRoomCommand;

public interface DeleteRoomUseServiceUseCase {
    Boolean execute(DeleteRoomCommand deleteRoomCommand);
}
