package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.RoomEntity
import com.hyungu.whoseturn.repositories.RoomRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "rooms")
class RoomController(val roomRepository: RoomRepository) {

    @GetMapping
    fun findAllRooms(): Iterable<RoomEntity> = roomRepository.findAll()

}