package com.custard.room_booking_service.application.usecase.room.impl;

import com.custard.room_booking_service.application.command.CreateRoomCommand;
import com.custard.room_booking_service.application.usecase.room.CreateRoomServiceUseCase;
import com.custard.room_booking_service.domain.enums.RoomStatus;
import com.custard.room_booking_service.domain.model.Room;
import com.custard.room_booking_service.domain.port.RoomRepository;
import com.custard.room_booking_service.domain.service.RoomValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateRoomServiceImpl implements CreateRoomServiceUseCase {

    private final RoomRepository roomRepository;

    @Override
    public Room execute(CreateRoomCommand command) {
        RoomValidator
                .validate(command.getName(), command.getFloor(),
                        command.getRate().getAmount(), command.getType());
        Room room = Room.create(
                UUID.randomUUID(),
                command.getName(),
                command.getFloor(),
                command.getRate(),
                command.getType(),
                RoomStatus.AVAILABLE);
        return roomRepository.save(room);
    }

}
