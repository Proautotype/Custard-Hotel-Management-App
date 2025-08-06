package com.custard.room_booking_service.infrastructure.persistence.mapper;

import com.custard.room_booking_service.domain.model.Room;
import com.custard.room_booking_service.domain.vo.Money;
import com.custard.room_booking_service.infrastructure.persistence.entity.RoomEntity;

public class RoomMapper {

    private RoomMapper(){}

    public static RoomEntity toEntity(Room room){
        return RoomEntity.builder()
        .name(room.getName())
        .floor(room.getFloor())
        .rate(room.getRate().getAmount())
        .status(room.getStatus())
        .type(room.getType())
        .build();
    }

    public static Room toDomain(RoomEntity entity){
        return Room.builder()
            .id(entity.getId())
            .name(entity.getName())
            .status(entity.getStatus())
            .type(entity.getType())
            .rate(new Money(entity.getRate()))
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpddatedAt())
        .build();
    }

    public static RoomEntity toOverride(RoomEntity entity, Room room){
        if(room.getName() != null){
            entity.setName(room.getName());
        }
        if(room.getFloor() != null){
            entity.setFloor(room.getFloor());
        }
        if(room.getRate() != null){
            entity.setRate(room.getRate().getAmount());
        }
        if(room.getStatus() != null){
            entity.setStatus(room.getStatus());
        }
        if(room.getType() != null){
            entity.setType(room.getType());
        }
        if(room.getStatus() != null){
            entity.setStatus(room.getStatus());
        }
        return entity;
    }

}
