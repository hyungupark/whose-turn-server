package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MEMBER_ID", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "ROOM_MEMBER",
            joinColumns = @JoinColumn(name = "MEMBERID"),
            inverseJoinColumns = @JoinColumn(name = "ROOM_ID")
    )
    private List<RoomEntity> rooms = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

}
