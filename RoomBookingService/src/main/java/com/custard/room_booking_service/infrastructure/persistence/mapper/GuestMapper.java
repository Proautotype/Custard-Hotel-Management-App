package com.custard.room_booking_service.infrastructure.persistence.mapper;

import com.custard.room_booking_service.application.command.guest.CreateGuestCommand;
import com.custard.room_booking_service.application.command.guest.UpdateGuestCommand;
import com.custard.room_booking_service.domain.model.Guest;
import com.custard.room_booking_service.infrastructure.persistence.entity.GuestEntity;

public class GuestMapper {
    private GuestMapper() {
    }

    public static GuestEntity toEntity(Guest guest) {
        return GuestEntity.builder()
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .phone(guest.getPhone())
                .email(guest.getEmail())
                .idNumber(guest.getIdNumber())
                .dateOfBirth(guest.getDateOfBirth())
                .build();
    }

    public static Guest toModel(GuestEntity entity) {
        return Guest.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .dateOfBirth(entity.getDateOfBirth())
                .idNumber(entity.getIdNumber())
                .build();
    }

    public static Guest toModel(CreateGuestCommand command){
        return Guest.builder()
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .email(command.getEmail())
                .phone(command.getPhone())
                .dateOfBirth(command.getDateOfBirth())
                .idNumber(command.getIdNumber())
                .build();
    }

    public static GuestEntity transform(GuestEntity entity, Guest guest){
        if(guest.getFirstName() != null){
            entity.setFirstName(guest.getFirstName());
        }
        if(guest.getLastName() != null){
            entity.setFirstName(guest.getLastName());
        }
        if(guest.getPhone() != null){
            entity.setPhone(guest.getPhone());
        }
        if(guest.getEmail() != null){
            entity.setPhone(guest.getPhone());
        }
        if(guest.getIdNumber() != null){
            entity.setIdNumber(guest.getIdNumber());
        }
        return entity;
    }

    public static Guest toModel(UpdateGuestCommand command) {
        return Guest.builder()
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .email(command.getEmail())
                .phone(command.getPhone())
                .dateOfBirth(command.getDateOfBirth())
                .idNumber(command.getIdNumber())
                .build();
    }
}
