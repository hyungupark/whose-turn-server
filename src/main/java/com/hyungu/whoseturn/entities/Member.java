package com.hyungu.whoseturn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "member_id", nullable = false)
    private String id;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @OneToMany(mappedBy = "member")
    private List<RoomMember> rooms = new ArrayList<RoomMember>();

    public Member() {
    }

    public Member(String name) {
        this.memberName = name;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getName() {
        return memberName;
    }

    // setter
    public void setName(String name) {
        this.memberName = name;
    }

}
