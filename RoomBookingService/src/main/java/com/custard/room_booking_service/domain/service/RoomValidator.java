package com.custard.room_booking_service.domain.service;

import com.custard.room_booking_service.domain.enums.RoomType;
import com.custard.room_booking_service.domain.model.Room;

import java.math.BigDecimal;

public class RoomValidator {

    private RoomValidator(){}

    public static void validate(String name, String floor, BigDecimal rate, RoomType type) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Room name must not be blank");
        }

        if (rate == null || (rate.compareTo(BigDecimal.ZERO) < 0)) {
            throw new IllegalArgumentException("Room rate must be non-negative");
        }

        if (type == null) {
            throw new IllegalArgumentException("Room type must be provided");
        }

        if (floor == null) {
            throw new IllegalArgumentException("floor type must be provided");
        }
    }

    public static void validate(Room room) {
        validate(room.getName(), room.getFloor(), room.getRate().getAmount(), room.getType());
    }
}
