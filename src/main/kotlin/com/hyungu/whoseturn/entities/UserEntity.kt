package com.hyungu.whoseturn.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import lombok.Data

@Entity(name = "users")
@Data
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,

    @ManyToMany
    @JoinTable(name = "room_user")
    var rooms: List<RoomEntity>,
)
