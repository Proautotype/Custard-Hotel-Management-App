package com.custard.room_booking_service.application.usecase.guest.impl;

import com.custard.room_booking_service.application.command.guest.CreateGuestCommand;
import com.custard.room_booking_service.application.usecase.guest.CreateGuestServiceUseCase;
import com.custard.room_booking_service.domain.model.Guest;
import com.custard.room_booking_service.domain.port.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGuestServiceUseCaseImpl implements CreateGuestServiceUseCase {

    private final GuestRepository guestRepository;

    @Override
    public Guest execute(CreateGuestCommand command) {
        Guest guest = Guest.create(
                command.getFirstName(),
                command.getLastName(),
                command.getPhone(),
                command.getEmail(),
                command.getIdNumber(),
                command.getDateOfBirth());
        return guestRepository.save(guest);
    }
}
