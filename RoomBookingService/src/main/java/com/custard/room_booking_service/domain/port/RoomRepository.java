package com.custard.room_booking_service.domain.port;

import com.custard.room_booking_service.domain.enums.RoomStatus;
import com.custard.room_booking_service.domain.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomRepository {
    Room save (Room room);
    Room updateRoom(Room room);
    Optional<Room> findById(UUID id);
    List<Room> findAll();
    void deleteById(UUID id);
    List<Room> findByStatus(RoomStatus status);
}
