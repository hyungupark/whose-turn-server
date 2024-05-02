package com.hyungu.whoseturn.repositories;

import com.hyungu.whoseturn.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
