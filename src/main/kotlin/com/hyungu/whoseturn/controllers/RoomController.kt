package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.RoomEntity
import com.hyungu.whoseturn.repositories.RoomRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController(value = "rooms")
class RoomController(val roomRepository: RoomRepository) {

    @GetMapping
    fun findAllRooms(): Iterable<RoomEntity> = roomRepository.findAll()

    @GetMapping("/{id}")
    fun findRoomById(@PathVariable(name = "id") id: String): Optional<RoomEntity> = roomRepository.findById(id)

    @PostMapping
    fun postRoom(@RequestBody room: RoomEntity): RoomEntity = roomRepository.save(room);

}