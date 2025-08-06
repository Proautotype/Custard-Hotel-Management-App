package com.custard.room_booking_service.application.usecase.room;

import com.custard.room_booking_service.domain.model.Room;

import java.util.List;

public interface ListAvailableRoomServiceUseCase {
    List<Room> execute();
}
