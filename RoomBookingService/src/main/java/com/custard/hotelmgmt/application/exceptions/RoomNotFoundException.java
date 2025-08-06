package com.custard.hotelmgmt.application.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String type, String value) {
        super(String.format("Room not found by $1 with $2", type, value));
    }
}
