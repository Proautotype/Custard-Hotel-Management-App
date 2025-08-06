package com.custard.hotelmgmt.application.usecase.room.impl;

import com.custard.hotelmgmt.application.command.CreateRoomCommand;
import com.custard.hotelmgmt.application.usecase.room.CreateRoomServiceUseCase;
import com.custard.hotelmgmt.domain.enums.RoomStatus;
import com.custard.hotelmgmt.domain.model.Room;
import com.custard.hotelmgmt.domain.port.RoomRepository;
import com.custard.hotelmgmt.domain.service.RoomValidator;
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
