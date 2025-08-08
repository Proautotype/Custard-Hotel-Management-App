package com.custard.room_booking_service.application.usecase.guest.impl;

import com.custard.room_booking_service.application.usecase.guest.GetAllGuestsServiceUseCase;
import com.custard.room_booking_service.domain.model.Guest;
import com.custard.room_booking_service.domain.port.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllGuestsServiceUseCaseImpl implements GetAllGuestsServiceUseCase {

    private final GuestRepository guestRepository;

    @Override
    public List<Guest> execute() {
        return  guestRepository.findAllGuests();
    }
}
