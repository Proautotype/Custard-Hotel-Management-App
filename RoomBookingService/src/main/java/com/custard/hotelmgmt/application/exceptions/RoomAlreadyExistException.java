package com.custard.hotelmgmt.application.exceptions;

public class RoomAlreadyExistException extends RuntimeException {
    public RoomAlreadyExistException(String message){
        super("AlreadyExist : " + message);
    }
}
