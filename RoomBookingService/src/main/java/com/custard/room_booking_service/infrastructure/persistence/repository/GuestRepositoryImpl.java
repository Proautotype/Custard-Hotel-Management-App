package com.custard.room_booking_service.infrastructure.persistence.repository;

import com.custard.room_booking_service.domain.model.Guest;
import com.custard.room_booking_service.domain.port.GuestRepository;
import com.custard.room_booking_service.infrastructure.persistence.entity.GuestEntity;
import com.custard.room_booking_service.infrastructure.persistence.mapper.GuestMapper;
import com.custard.room_booking_service.infrastructure.persistence.repository.jpa.JpaGuestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GuestRepositoryImpl implements GuestRepository {

    private final JpaGuestRepository jpaGuestRepository;

    @Override
    public Guest save(Guest guest) {
        GuestEntity guestEntity = GuestMapper.toEntity(guest);
        jpaGuestRepository.save(guestEntity);
        return GuestMapper.toModel(guestEntity);
    }

    @Override
    public Optional<Guest> findById(UUID id) {
        Optional<GuestEntity> guest = jpaGuestRepository.findById(id);
        if(guest.isEmpty()){
            throw new EntityNotFoundException("Guest not found");
        }
        return Optional.of(GuestMapper.toModel(guest.get()));
    }

    @Override
    public List<Guest> findAllGuests() {
        return jpaGuestRepository.findAll().stream().map(GuestMapper::toModel).toList();
    }

    @Override
    public List<Guest> searchByName(String name) {
        jpaGuestRepository.findByName(name, name);
        return List.of();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        try{
            jpaGuestRepository.findById(id).ifPresent(jpaGuestRepository::delete);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Guest update(UUID id, Guest guest) {
        GuestEntity existingGuest = jpaGuestRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guest not found"));

        GuestEntity updatedGuest = GuestMapper.transform(existingGuest, guest);
        jpaGuestRepository.save(updatedGuest);
        return GuestMapper.toModel(updatedGuest);
    }
}
