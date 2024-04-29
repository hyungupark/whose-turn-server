package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

@Entity
@IdClass(RoomMember.class)
public class RoomMember {

    @Id
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "room_name")
    private String roomName;

}
