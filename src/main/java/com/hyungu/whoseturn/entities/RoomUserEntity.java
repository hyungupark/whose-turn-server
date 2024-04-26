package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

@Entity
@IdClass(RoomUserEntity.class)
public class RoomUserEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private RoomEntity room;
    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;
}
