package com.custard.room_booking_service.domain.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DateRange {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public DateRange(LocalDateTime startTime, LocalDateTime endTime){

        if(startTime == null || endTime == null){
            throw new IllegalStateException("Start date and End date should not be null");
        }

        if(startTime.isAfter(endTime)){
            throw new IllegalStateException("Invalid date range");
        }

        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean overlaps(DateRange other){
        return !this.endTime.isBefore(other.startTime) || this.startTime.isAfter(other.endTime);
    }
    public boolean includes(LocalDateTime date) {
        return !date.isBefore(startTime) && !date.isAfter(endTime);
    }

}
