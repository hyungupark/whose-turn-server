package com.hyungu.whoseturn.entities

import jakarta.annotation.Nullable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import lombok.Data

@Entity(name = "users")
@Data
data class UserEntity(
    @Id
    @GeneratedValue
    val id: Long?,

    var name: String,

    @OneToMany
    @Nullable
    var posts: List<PostEntity>?,

    @OneToMany
    @Nullable
    var comments: List<CommentEntity>?
)
