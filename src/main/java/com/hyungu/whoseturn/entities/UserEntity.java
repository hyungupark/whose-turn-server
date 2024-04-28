package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MEMBER_ID", nullable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "USER_ID")
    private List<RoomUserEntity> roomUseris;

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
