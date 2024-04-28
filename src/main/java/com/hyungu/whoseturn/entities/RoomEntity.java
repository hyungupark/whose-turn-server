package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ROOMS")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ROOM_ID", nullable = false)
    private String id;

    @ManyToMany(mappedBy = "ROOM_ID")
    private List<RoomUserEntity> roomUsers;

    public RoomEntity() {
    }

    // getter
    public String getId() {
        return id;
    }

}
