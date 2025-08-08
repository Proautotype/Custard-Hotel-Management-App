package com.custard.room_booking_service.interfaces.rest.controller;

import com.custard.room_booking_service.application.command.guest.CreateGuestCommand;
import com.custard.room_booking_service.application.command.guest.UpdateGuestCommand;
import com.custard.room_booking_service.application.command.room.DeleteRoomCommand;
import com.custard.room_booking_service.application.usecase.guest.*;
import com.custard.room_booking_service.domain.model.Guest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/guest")
@RequiredArgsConstructor
@Tag(name = "Guest Management", description = "Operations pertaining to room management")
public class GuestController {

    private final CreateGuestServiceUseCase createGuestServiceUseCase;
    private final UpdateGuestServiceUseCase updateGuestServiceUseCase;
    private final GetGuestByIdServiceUseCase getGuestByIdServiceUseCase;
    private final GetAllGuestsServiceUseCase getGuestsServiceUseCase;
    private final DeleteGuestServiceUseCase deleteGuestServiceUseCase;

    @PostMapping
    public ResponseEntity<Guest> create(CreateGuestCommand command){
        Guest execute = createGuestServiceUseCase.execute(command);
        return ResponseEntity.status(201).body(execute);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests(){
        List<Guest> guests = getGuestsServiceUseCase.execute();
        return ResponseEntity.status(200).body(guests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable("id") String id){
        Guest guests = getGuestByIdServiceUseCase.execute(UUID.fromString(id));
        return ResponseEntity.status(200).body(guests);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(DeleteRoomCommand command){
        boolean deleted = deleteGuestServiceUseCase.execute(command);
        return ResponseEntity.status(203).body(deleted);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> update(@PathVariable("id") String id, UpdateGuestCommand command){
        Guest updated = updateGuestServiceUseCase.execute(
                UUID.fromString(id),
                command
        );
        return ResponseEntity.status(202).body(updated);
    }

}
