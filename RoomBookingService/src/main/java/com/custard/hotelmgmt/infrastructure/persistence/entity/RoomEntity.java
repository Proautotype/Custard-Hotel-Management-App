package com.custard.hotelmgmt.infrastructure.persistence.entity;

import com.custard.hotelmgmt.domain.enums.RoomStatus;
import com.custard.hotelmgmt.domain.enums.RoomType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
@Entity
public class RoomEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String floor;
    private BigDecimal rate;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    @Enumerated(EnumType.STRING)
    private RoomStatus status; 
}
