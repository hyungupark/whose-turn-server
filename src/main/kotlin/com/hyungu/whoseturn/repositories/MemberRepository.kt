package com.hyungu.whoseturn.repositories

import com.hyungu.whoseturn.entities.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<MemberEntity, Long>