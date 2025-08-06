package com.custard.hotelmgmt.application.usecase.room.impl;

import com.custard.hotelmgmt.application.command.UpdateRoomCommand;
import com.custard.hotelmgmt.application.usecase.room.UpdateRoomServiceUseCase;
import com.custard.hotelmgmt.domain.model.Room;
import com.custard.hotelmgmt.domain.port.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateRoomServiceUseCaseImpl implements UpdateRoomServiceUseCase {

    private final RoomRepository roomRepository;

    @Override
    public Room execute(UUID roomId, UpdateRoomCommand command) {
       
        Room room = Room.create(
                roomId,
                command.getName(),
                command.getFloor(),
                command.getRate(),
                command.getType(),
                command.getStatus());
                
        return roomRepository.updateRoom(room);
    }

}
