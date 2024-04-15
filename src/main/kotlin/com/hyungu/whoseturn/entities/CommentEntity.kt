package com.hyungu.whoseturn.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import lombok.Data

@Entity(name = "comments")
@Data
data class CommentEntity(
    @Id
    @GeneratedValue
    val id: Long?,

    var content: String,

    @ManyToOne
    var user: UserEntity,

    @ManyToOne
    var post: PostEntity
)
