package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

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
