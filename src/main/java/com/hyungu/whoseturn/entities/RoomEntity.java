package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    public RoomEntity() {
    }

    // getter
    public String getId() {
        return id;
    }

}
