package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.RoomEntity
import com.hyungu.whoseturn.entities.UserEntity
import com.hyungu.whoseturn.repositories.RoomRepository
import com.hyungu.whoseturn.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/{user_id}")
    fun postRoom(@PathVariable(name = "user_id") userId: String, @RequestBody room: RoomEntity): RoomEntity {
        if (userRepository.existsById(userId)) {
            val user: UserEntity = userRepository.findById(userId).orElseThrow();
            // TODO: save "Room"
        }
    }

}