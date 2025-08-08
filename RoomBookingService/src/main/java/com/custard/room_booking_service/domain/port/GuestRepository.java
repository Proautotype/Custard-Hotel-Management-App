package com.custard.room_booking_service.domain.port;

import com.custard.room_booking_service.domain.model.Guest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestRepository {
    Guest save (Guest guest);
    Optional<Guest> findById(UUID id);
    List<Guest> findAllGuests();
    List<Guest> searchByName(String name);
    void delete(UUID id);
    Guest update(UUID id, Guest guest);
} 