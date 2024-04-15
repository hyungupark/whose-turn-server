package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.PostEntity
import com.hyungu.whoseturn.repositories.PostCrudRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/crud/posts")
class PostController(private val postCrudRepository: PostCrudRepository) {

    // Get
    @GetMapping
    fun getAllPosts(): Iterable<PostEntity> = postCrudRepository.findAll()

    @GetMapping("/{id}")
    fun getPostById(@PathVariable("id") id: Long): Optional<PostEntity> = postCrudRepository.findById(id)

    // Post
    @PostMapping
    fun postPost(@RequestBody post: PostEntity): PostEntity = postCrudRepository.save(post)

    // Put
    @PutMapping("/{id}")
    fun putPost(@PathVariable("id") id: Long, @RequestBody post: PostEntity): ResponseEntity<PostEntity> =
        if (postCrudRepository.existsById(id))
            ResponseEntity<PostEntity>(postCrudRepository.save(post), HttpStatus.OK)
        else
            ResponseEntity<PostEntity>(postCrudRepository.save(post), HttpStatus.CREATED)

    // Delete
    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable("id") id: Long): Unit = postCrudRepository.deleteById(id)

}