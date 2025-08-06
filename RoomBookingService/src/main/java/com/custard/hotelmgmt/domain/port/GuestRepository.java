package com.custard.hotelmgmt.domain.port;

import com.custard.hotelmgmt.domain.model.Guest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestRepository {
    Guest save (Guest guest);
    Optional<Guest> findById(UUID id);
    List<Guest> findAll();
    List<Guest> searchByName(String name);
    void delete(UUID id);
} 