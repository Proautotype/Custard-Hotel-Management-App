package com.custard.room_booking_service.application.command.room;

import com.custard.room_booking_service.domain.enums.RoomStatus;
import com.custard.room_booking_service.domain.enums.RoomType;
import com.custard.room_booking_service.domain.vo.Money;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateRoomCommand {
    @NotBlank
    private String name;
    @NotBlank
    private String floor;
    @NotBlank
    private Money rate;
    @NotBlank
    private RoomType type;
    @NotBlank
    private RoomStatus status;
}
