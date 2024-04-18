package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.RoomEntity
import com.hyungu.whoseturn.repositories.RoomRepository
import com.hyungu.whoseturn.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController(value = "rooms")
class RoomController(
    private val roomRepository: RoomRepository,
    private val userRepository: UserRepository
) {

    @GetMapping
    fun findAllRooms(): Iterable<RoomEntity> = roomRepository.findAll()

    @GetMapping("/{id}")
    fun findRoomById(@PathVariable(name = "id") id: String): Optional<RoomEntity> = roomRepository.findById(id)

}