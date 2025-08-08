package com.custard.room_booking_service.application.usecase.guest.impl;

import com.custard.room_booking_service.application.command.guest.UpdateGuestCommand;
import com.custard.room_booking_service.application.usecase.guest.UpdateGuestServiceUseCase;
import com.custard.room_booking_service.domain.model.Guest;
import com.custard.room_booking_service.domain.port.GuestRepository;
import com.custard.room_booking_service.infrastructure.persistence.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateGuestServiceUseCaseImpl implements UpdateGuestServiceUseCase {

    private final GuestRepository repository;

    @Override
    public Guest execute(UUID id, UpdateGuestCommand command) {
        Guest guest = GuestMapper.toModel(command);
        return  repository.update(id, guest);
    }
}
