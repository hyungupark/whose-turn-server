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
class MemberController(private val userRepository: UserRepository) {

    @GetMapping
    fun getAllMembers(): List<UserEntity> = userRepository.findAll()

    @PostMapping
    fun createMember(@RequestBody user: UserEntity): UserEntity = userRepository.save(user)

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): ResponseEntity<UserEntity> =
        userRepository.findById(id).map { user -> ResponseEntity.ok(user) }
            .orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: Long, @RequestBody newUser: UserEntity): ResponseEntity<UserEntity> =
        userRepository.findById(id).map { user ->
            val updatedMember: UserEntity = user.copy(id = newUser.id, name = newUser.name)
            ResponseEntity.ok().body(userRepository.save(updatedMember))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Void> =
        userRepository.findById(id).map { user ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())

}

@RestController
@RequestMapping("/crud/users")
class MemberCrudController(private val userCrudRepository: UserCrudRepository) {

    @GetMapping
    fun getAllMembers(): Iterable<UserEntity> = userCrudRepository.findAll()

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): Optional<UserEntity> {
        return userCrudRepository.findById(id);
    }

    @PostMapping
    fun postMember(@RequestBody user: UserEntity): UserEntity = userCrudRepository.save(user)

    @PutMapping("/{id}")
    fun putMember(@PathVariable id: Long, @RequestBody user: UserEntity): ResponseEntity<UserEntity> =
        if (userCrudRepository.existsById(id))
            ResponseEntity<UserEntity>(
                userCrudRepository.save(user),
                HttpStatus.CREATED
            )
        else
            ResponseEntity<UserEntity>(
                userCrudRepository.save(user),
                HttpStatus.OK
            )

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long) = userCrudRepository.deleteById(id)

}
