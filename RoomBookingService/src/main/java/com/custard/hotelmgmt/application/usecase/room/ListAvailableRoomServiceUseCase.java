package com.custard.hotelmgmt.application.usecase.room;

import com.custard.hotelmgmt.domain.model.Room;

import java.util.List;

public interface ListAvailableRoomServiceUseCase {
    List<Room> execute();
}
