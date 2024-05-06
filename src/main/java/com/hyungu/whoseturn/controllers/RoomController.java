package com.hyungu.whoseturn.controllers;

import com.hyungu.whoseturn.entities.Member;
import com.hyungu.whoseturn.entities.Room;
import com.hyungu.whoseturn.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.findAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id).orElse(null);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        Room findRoom = getRoomById(room.getId());
        if (findRoom == null) {
            return ResponseEntity.notFound().build();
        }
        findRoom.setName(room.getName());
        findRoom.setMembers(room.getMembers());
        return ResponseEntity.ok(roomService.saveRoom(findRoom));
    }

    public ResponseEntity<Room> changeAdmin(@RequestBody Room room, Member newAdmin) {
        Room findRoom = getRoomById(room.getId());
        findRoom.setAdmin(newAdmin);
        return ResponseEntity.ok(roomService.saveRoom(findRoom));
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}
