package com.custard.room_booking_service.infrastructure.persistence.repository.jpa;

import com.custard.room_booking_service.infrastructure.persistence.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaGuestRepository extends JpaRepository<GuestEntity, UUID> {
    @Query("Select g from GuestEntity g where g.firstName LIKE %?1% or g.lastName LIKE %?2%")
    List<GuestEntity> findByName(String firstName, String lastName);
}
