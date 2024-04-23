package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RoomUserEntity> roomUsers = new ArrayList<>();

    public RoomEntity() {
    }

    // getter
    public String getId() {
        return id;
    }

}
