package com.custard.hotelmgmt.interfaces.rest.controller;

import com.custard.hotelmgmt.application.command.CreateRoomCommand;
import com.custard.hotelmgmt.application.command.DeleteRoomCommand;
import com.custard.hotelmgmt.application.command.UpdateRoomCommand;
import com.custard.hotelmgmt.application.usecase.room.CreateRoomServiceUseCase;
import com.custard.hotelmgmt.application.usecase.room.DeleteRoomUseServiceUseCase;
import com.custard.hotelmgmt.application.usecase.room.ListAvailableRoomServiceUseCase;
import com.custard.hotelmgmt.application.usecase.room.UpdateRoomServiceUseCase;
import com.custard.hotelmgmt.domain.model.Room;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
@Tag(name = "Room Management", description = "Operations pertaining to room management")
public class RoomController {

    private final CreateRoomServiceUseCase createRoomServiceUseCase;
    private final ListAvailableRoomServiceUseCase listAvailableRoomServiceUseCase;
    private final UpdateRoomServiceUseCase updateRoomServiceUseCase;
    private final DeleteRoomUseServiceUseCase deleteRoomUseServiceUseCase;

    @Operation(
        description = "Create Room api is responsible for creating a new room, kindly provide the details needed, each value is validated",
        summary = "Creates a new room"
    )
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody CreateRoomCommand createRoomCommand){
        Room createRoom = createRoomServiceUseCase.execute(createRoomCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRoom);
    }

    @Operation(
        description = "This api responsible for retrieving all rooms without filters"
    )
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(){
        var rooms = listAvailableRoomServiceUseCase.execute();
       return ResponseEntity.ok().body(rooms);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update Room with id using provided data")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") String id, @RequestBody UpdateRoomCommand command) {
        Room room = updateRoomServiceUseCase.execute(UUID.fromString(id), command);
        return  ResponseEntity.status(203).body(room);
    }

    @Operation(description = "Delete Room with id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRoom(@PathVariable("id") String id){
        DeleteRoomCommand command = new DeleteRoomCommand(UUID.fromString(id));
        Boolean deletedRoom = deleteRoomUseServiceUseCase.execute(command);
        return ResponseEntity.status(204).body(deletedRoom);
    }

}
