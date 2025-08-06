package com.custard.room_booking_service.application.usecase.room.impl;

import com.custard.room_booking_service.application.command.DeleteRoomCommand;
import com.custard.room_booking_service.application.usecase.room.DeleteRoomUseServiceUseCase;
import com.custard.room_booking_service.domain.port.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRoomUseServiceUseCaseImpl implements DeleteRoomUseServiceUseCase {

    private final RoomRepository repository;

    @Override
    public Boolean execute(DeleteRoomCommand deleteRoomCommand) {
        repository.deleteById(deleteRoomCommand.getRoomId());
        return true;
    }
}
