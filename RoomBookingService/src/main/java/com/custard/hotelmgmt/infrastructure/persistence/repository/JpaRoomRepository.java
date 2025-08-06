package com.custard.hotelmgmt.infrastructure.persistence.repository;

import com.custard.hotelmgmt.domain.enums.RoomStatus;
import com.custard.hotelmgmt.domain.enums.RoomType;
import com.custard.hotelmgmt.infrastructure.persistence.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaRoomRepository extends JpaRepository<RoomEntity, UUID>{
    List<RoomEntity> findByStatus(RoomStatus status);
    List<RoomEntity> findByType(RoomType type);
}
