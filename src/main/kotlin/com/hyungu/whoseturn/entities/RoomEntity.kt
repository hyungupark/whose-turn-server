package com.hyungu.whoseturn.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "rooms")
data class RoomEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?
)