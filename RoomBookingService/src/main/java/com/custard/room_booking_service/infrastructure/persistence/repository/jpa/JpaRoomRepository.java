package com.custard.room_booking_service.infrastructure.persistence.repository.jpa;

import com.custard.room_booking_service.domain.enums.RoomStatus;
import com.custard.room_booking_service.domain.enums.RoomType;
import com.custard.room_booking_service.infrastructure.persistence.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaRoomRepository extends JpaRepository<RoomEntity, UUID>{
    List<RoomEntity> findByStatus(RoomStatus status);
    List<RoomEntity> findByType(RoomType type);
}
