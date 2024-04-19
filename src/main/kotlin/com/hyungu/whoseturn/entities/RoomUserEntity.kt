package com.hyungu.whoseturn.entities

import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

@Table(name = "room_user")
data class RoomUserEntity(
    @Id
    @JoinColumn(name = "id", table = "rooms")
    val roomId: String,

    @Id
    @JoinColumn(name = "id", table = "users")
    val userId: String,

    var name: String
)