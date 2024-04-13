package com.hyungu.whoseturn.controllers

import com.hyungu.whoseturn.entities.MemberEntity
import com.hyungu.whoseturn.repositories.MemberCrudRepository
import com.hyungu.whoseturn.repositories.MemberRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

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
    fun updateMember(@PathVariable id: Long, @RequestBody newMember: MemberEntity): ResponseEntity<MemberEntity> =
        memberRepository.findById(id).map { member ->
            val updatedMember: MemberEntity = member.copy(id = newMember.id, name = newMember.name)
            ResponseEntity.ok().body(memberRepository.save(updatedMember))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Void> =
        memberRepository.findById(id).map { member ->
            memberRepository.delete(member)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())

}

@RestController
@RequestMapping("/crud/members")
class MemberCrudController(private val memberCrudRepository: MemberCrudRepository) {

    @GetMapping
    fun getAllMembers(): Iterable<MemberEntity> = memberCrudRepository.findAll()

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): Optional<MemberEntity> {
        return memberCrudRepository.findById(id);
    }

    @PostMapping
    fun postMember(@RequestBody member: MemberEntity): MemberEntity = memberCrudRepository.save(member)

    @PutMapping("/{id}")
    fun putMember(@PathVariable id: Long, @RequestBody member: MemberEntity): ResponseEntity<MemberEntity> =
        if (memberCrudRepository.existsById(id))
            ResponseEntity<MemberEntity>(
                memberCrudRepository.save(member),
                HttpStatus.CREATED
            )
        else
            ResponseEntity<MemberEntity>(
                memberCrudRepository.save(member),
                HttpStatus.OK
            )

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long) = memberCrudRepository.deleteById(id)

}
