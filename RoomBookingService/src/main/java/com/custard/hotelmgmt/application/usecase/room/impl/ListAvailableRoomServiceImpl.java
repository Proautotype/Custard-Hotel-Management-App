package com.custard.hotelmgmt.application.usecase.room.impl;

import com.custard.hotelmgmt.application.usecase.room.ListAvailableRoomServiceUseCase;
import com.custard.hotelmgmt.domain.model.Room;
import com.custard.hotelmgmt.domain.port.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListAvailableRoomServiceImpl implements ListAvailableRoomServiceUseCase{

    private final RoomRepository repository;

    @Override
    public List<Room> execute() {
       return repository.findAll();
    }

}
