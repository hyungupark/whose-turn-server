package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.MemberEntity
import com.hyungu.whoseturn.repositories.MemberRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(private val memberRepository: MemberRepository) {

    @GetMapping
    fun getAllMembers(): List<MemberEntity> = memberRepository.findAll()

    @PostMapping
    fun createMember(@RequestBody member: MemberEntity): MemberEntity = memberRepository.save(member)

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): ResponseEntity<MemberEntity> =
        memberRepository.findById(id).map { member -> ResponseEntity.ok(member) }
            .orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody newMember: MemberEntity): ResponseEntity<MemberEntity> =
        memberRepository.findById(id).map {
            val updatedMember: MemberEntity = newMember
            ResponseEntity.ok().body(memberRepository.save(updatedMember))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> =
        memberRepository.findById(id).map { member ->
            memberRepository.delete(member)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())

    @GetMapping("/hello")
    fun hello() = "Hello, World!"

}