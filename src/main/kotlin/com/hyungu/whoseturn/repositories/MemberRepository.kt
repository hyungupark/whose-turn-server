package com.hyungu.whoseturn.repositories

import com.hyungu.whoseturn.entities.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface MemberRepository : JpaRepository<MemberEntity, Long>
interface MemberCrudRepository : CrudRepository<MemberEntity, Long>
