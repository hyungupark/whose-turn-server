package com.hyungu.whoseturn.repositories

import com.hyungu.whoseturn.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository : JpaRepository<UserEntity, Long>
interface UserCrudRepository : CrudRepository<UserEntity, Long>
