package com.custard.room_booking_service.infrastructure.persistence.repository;

import com.custard.room_booking_service.application.exceptions.RoomNotFoundException;
import com.custard.room_booking_service.domain.enums.RoomStatus;
import com.custard.room_booking_service.domain.model.Room;
import com.custard.room_booking_service.domain.port.RoomRepository;
import com.custard.room_booking_service.infrastructure.persistence.entity.RoomEntity;
import com.custard.room_booking_service.infrastructure.persistence.mapper.RoomMapper;
import com.custard.room_booking_service.infrastructure.persistence.repository.jpa.JpaRoomRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoomRepositoryImpl implements RoomRepository {

    private final Logger logger = LoggerFactory.getLogger(RoomRepositoryImpl.class);

    private final JpaRoomRepository jpaRoomRepository;

    @Override
    public Room save(Room room) {
        try {
            RoomEntity roomEntity = RoomMapper.toEntity(room);
            RoomEntity entity = jpaRoomRepository.save(roomEntity);
            return RoomMapper.toDomain(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Optional<Room> findById(UUID id) {
        return jpaRoomRepository.findById(id).map(RoomMapper::toDomain);
    }

    @Override
    public List<Room> findAll() {
        return jpaRoomRepository.findAll().stream().map(RoomMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        try {
            jpaRoomRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Unable to delete data with id " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Room> findByStatus(RoomStatus status) {
        return jpaRoomRepository.findByStatus(status)
                .stream()
                .map(RoomMapper::toDomain)
                .toList();
    }

    @Override
    public Room updateRoom(Room room) {
        var entity = jpaRoomRepository
                .findById(room.getId())
                .orElseThrow(() -> new RoomNotFoundException("id", room.getId().toString()));

        RoomMapper.toOverride(entity, room);
        RoomEntity updated = jpaRoomRepository.save(entity);
        return RoomMapper.toDomain(updated);

    }

}
