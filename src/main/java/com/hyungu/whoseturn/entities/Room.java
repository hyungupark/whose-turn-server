package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id", nullable = false)
    private String id;

    @OneToMany(mappedBy = "room")
    private List<RoomMember> roomMembers = new ArrayList<RoomMember>();

    // getter
    public String getId() {
        return id;
    }

}
