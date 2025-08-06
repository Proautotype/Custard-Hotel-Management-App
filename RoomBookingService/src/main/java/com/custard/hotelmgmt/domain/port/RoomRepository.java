package com.custard.hotelmgmt.domain.port;

import com.custard.hotelmgmt.domain.enums.RoomStatus;
import com.custard.hotelmgmt.domain.model.Room;

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
