package com.custard.hotelmgmt.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteRoomCommand {
    private UUID roomId;
}
