package com.hyungu.whoseturn.repositories

import com.hyungu.whoseturn.entities.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, String>
