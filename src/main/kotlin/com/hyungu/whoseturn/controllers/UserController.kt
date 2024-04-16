package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.UserEntity
import com.hyungu.whoseturn.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/users")
class UserCrudController(private val userRepository: UserRepository) {

    // Get
    @GetMapping
    fun getAllUsers(): Iterable<UserEntity> = userRepository.findAll()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): Optional<UserEntity> {
        return userRepository.findById(id);
    }

    // Post
    @PostMapping
    fun postUser(@RequestBody user: UserEntity): UserEntity = userRepository.save(user)

    // Put
    @PutMapping("/{id}")
    fun putUser(@PathVariable id: String, @RequestBody user: UserEntity): ResponseEntity<UserEntity> =
        if (userRepository.existsById(id))
            ResponseEntity<UserEntity>(
                userRepository.save(user),
                HttpStatus.OK
            )
        else
            ResponseEntity<UserEntity>(
                userRepository.save(user),
                HttpStatus.CREATED
            )

    // Delete
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String) = userRepository.deleteById(id)

}
