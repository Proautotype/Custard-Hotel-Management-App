package com.custard.hotelmgmt.domain.service;

import com.custard.hotelmgmt.domain.enums.RoomType;
import com.custard.hotelmgmt.domain.model.Room;

import java.math.BigDecimal;

public class RoomValidator {

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
    }

    public static void validate(Room room) {
        if (room.getName() == null || room.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Room name cannot be empty");
        }

        if (room.getRate().validateAmount()) {
            throw new IllegalArgumentException("Room rate must be positive");
        }

        if (room.getType() == null) {
            throw new IllegalArgumentException("Room type must be specified");
        }
    }
}
