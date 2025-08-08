package com.custard.room_booking_service.domain.model;

import com.custard.room_booking_service.domain.service.BookingValidator;
import com.custard.room_booking_service.domain.vo.DateRange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private UUID id;
    private UUID roomId;
    private UUID guestId;
    private DateRange period;

    public static Booking create(UUID id, UUID roomId, UUID guestId, DateRange period) {
        Booking booking = new Booking(id, roomId, guestId, period);
        BookingValidator.validate(booking);
        return booking;
    }

}
