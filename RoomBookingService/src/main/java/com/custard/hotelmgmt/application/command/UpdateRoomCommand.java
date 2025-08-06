package com.custard.hotelmgmt.application.command;

import com.custard.hotelmgmt.domain.enums.RoomStatus;
import com.custard.hotelmgmt.domain.enums.RoomType;
import com.custard.hotelmgmt.domain.vo.Money;
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
