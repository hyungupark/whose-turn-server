package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.UserEntity
import com.hyungu.whoseturn.repositories.UserCrudRepository
import com.hyungu.whoseturn.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {

    // Get
    @GetMapping
    fun getAllUsers(): List<UserEntity> = userRepository.findAll()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserEntity> =
        userRepository
            .findById(id)
            .map { user -> ResponseEntity.ok(user) }
            .orElse(ResponseEntity.notFound().build())

    // Post
    @PostMapping
    fun createUser(@RequestBody user: UserEntity): UserEntity = userRepository.save(user)


    // Put
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody newUser: UserEntity): ResponseEntity<UserEntity> =
        userRepository
            .findById(id)
            .map { user ->
                val updatedMember: UserEntity = user.copy(id = newUser.id, name = newUser.name)
                ResponseEntity.ok().body(userRepository.save(updatedMember))
            }
            .orElse(ResponseEntity.notFound().build())

    // Delete
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> =
        userRepository
            .findById(id)
            .map { user ->
                userRepository.delete(user)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())

}

@RestController
@RequestMapping("/crud/users")
class UserCrudController(private val userCrudRepository: UserCrudRepository) {

    // Get
    @GetMapping
    fun getAllUsers(): Iterable<UserEntity> = userCrudRepository.findAll()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): Optional<UserEntity> {
        return userCrudRepository.findById(id);
    }

    // Post
    @PostMapping
    fun postUser(@RequestBody user: UserEntity): UserEntity = userCrudRepository.save(user)

    // Put
    @PutMapping("/{id}")
    fun putUser(@PathVariable id: Long, @RequestBody user: UserEntity): ResponseEntity<UserEntity> =
        if (userCrudRepository.existsById(id))
            ResponseEntity<UserEntity>(
                userCrudRepository.save(user),
                HttpStatus.OK
            )
        else
            ResponseEntity<UserEntity>(
                userCrudRepository.save(user),
                HttpStatus.CREATED
            )

    // Delete
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userCrudRepository.deleteById(id)

}
