package com.custard.room_booking_service.domain.model;

import com.custard.room_booking_service.domain.enums.RoomStatus;
import com.custard.room_booking_service.domain.enums.RoomType;
import com.custard.room_booking_service.domain.service.RoomValidator;
import com.custard.room_booking_service.domain.vo.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private static final Logger logger = LoggerFactory.getLogger(Room.class);

    private UUID id;
    private String name;
    private String floor;
    private Money rate;
    private RoomType type;
    private RoomStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Room create(UUID id, String name, String floor , Money rate, RoomType type, RoomStatus status){
        logger.info("Create new Room Object");
       
        Room room = new Room(
            id, name,floor, rate, type, status, LocalDateTime.now() , null
        );
        RoomValidator.validate(room);
        return room;
    }

}
