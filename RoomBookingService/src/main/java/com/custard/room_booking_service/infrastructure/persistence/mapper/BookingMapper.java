package com.custard.room_booking_service.infrastructure.persistence.mapper;

import com.custard.room_booking_service.domain.model.Booking;
import com.custard.room_booking_service.domain.vo.DateRange;
import com.custard.room_booking_service.infrastructure.persistence.entity.BookingEntity;

public class BookingMapper {
    private BookingMapper(){}

    public static BookingEntity toEntity(Booking booking){
        return BookingEntity.builder()
                .roomId(booking.getRoomId())
                .guestId(booking.getGuestId())
                .startTime(booking.getPeriod().getStartTime())
                .endTime(booking.getPeriod().getEndTime())
                .build();
    }

    public static Booking toDto(BookingEntity entity){
        return Booking.builder()
                .id(entity.getId())
                .roomId(entity.getRoomId())
                .guestId(entity.getGuestId())
                .period(new DateRange(
                        entity.getStartTime(),
                        entity.getEndTime()
                ))
                .build();
    }

}
