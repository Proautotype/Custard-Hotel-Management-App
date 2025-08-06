package com.custard.hotelmgmt.domain.port;

import com.custard.hotelmgmt.domain.model.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Booking save(Booking booking);
    Optional<Booking> findById(UUID id);
    List<Booking> findAll();
    List<Booking> findBookingByRoomId(UUID id);
    List<Booking> findBookingsBetweenRange(LocalDateTime start, LocalDateTime end);
    void delete(UUID id);
    boolean existsByRoomIdAndDateRange(UUID roomId, LocalDate start, LocalDate end);
}
