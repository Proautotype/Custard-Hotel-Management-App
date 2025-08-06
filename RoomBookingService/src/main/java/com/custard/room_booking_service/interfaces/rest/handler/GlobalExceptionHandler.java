package com.custard.room_booking_service.interfaces.rest.handler;

import com.custard.room_booking_service.application.exceptions.RoomAlreadyExistException;
import com.custard.room_booking_service.application.exceptions.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice()
public class GlobalExceptionHandler {

    private static final String MESSAGE = "message";
    private static final String STATUS = "status";

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleRoomNotfoundException(RoomNotFoundException exception) {
        var body = new HashMap<String, Object>();
        body.put(MESSAGE, exception.getMessage());
        body.put(STATUS, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(RoomAlreadyExistException.class)
    public ResponseEntity<Map<String, Object>> handleRoomAllExistsException(RoomAlreadyExistException exception) {
        var body = new HashMap<String, Object>();
        body.put(MESSAGE, exception.getMessage());
        body.put(STATUS, HttpStatus.CONFLICT);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleRoomAllGlobalException(Exception exception) {
        var body = new HashMap<String, Object>();
        body.put(MESSAGE, exception.getMessage());
        body.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

}
