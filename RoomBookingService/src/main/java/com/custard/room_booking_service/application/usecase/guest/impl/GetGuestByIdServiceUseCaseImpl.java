package com.custard.room_booking_service.application.usecase.guest.impl;

import com.custard.room_booking_service.application.usecase.guest.GetGuestByIdServiceUseCase;
import com.custard.room_booking_service.domain.model.Guest;
import com.custard.room_booking_service.domain.port.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetGuestByIdServiceUseCaseImpl implements GetGuestByIdServiceUseCase {

    private final GuestRepository guestRepository;

    @Override
    public Guest execute(UUID id) {
        return guestRepository.findById(id).orElse(null);
    }
}
