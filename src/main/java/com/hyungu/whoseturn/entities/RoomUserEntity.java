package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "room_user")
public class RoomUserEntity {
    @Id
    private String room_id;

    @Id
    private String user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
