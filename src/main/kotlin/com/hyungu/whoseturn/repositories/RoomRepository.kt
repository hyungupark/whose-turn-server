package com.hyungu.whoseturn.repositories

import com.hyungu.whoseturn.entities.RoomEntity
import org.springframework.data.repository.CrudRepository

interface RoomRepository : CrudRepository<RoomEntity, String> {
}