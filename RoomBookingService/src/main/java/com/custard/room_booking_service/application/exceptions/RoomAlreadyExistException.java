package com.custard.room_booking_service.application.exceptions;

public class RoomAlreadyExistException extends RuntimeException {
    public RoomAlreadyExistException(String message){
        super("AlreadyExist : " + message);
    }
}
