package com.custard.room_booking_service.application.usecase.guest.impl;

import com.custard.room_booking_service.application.command.room.DeleteRoomCommand;
import com.custard.room_booking_service.application.usecase.guest.DeleteGuestServiceUseCase;
import com.custard.room_booking_service.domain.port.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGuestServiceUseCaseImpl implements DeleteGuestServiceUseCase {

    private final GuestRepository guestRepository;

    @Override
    public boolean execute(DeleteRoomCommand command) {
        guestRepository.delete(command.getRoomId());
        return false;
    }
}
