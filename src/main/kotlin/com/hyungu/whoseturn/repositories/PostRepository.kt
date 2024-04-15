package com.hyungu.whoseturn.repositories

import com.hyungu.whoseturn.entities.PostEntity
import org.springframework.data.repository.CrudRepository

interface PostCrudRepository : CrudRepository<PostEntity, Long>
