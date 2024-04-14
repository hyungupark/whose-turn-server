package com.hyungu.whoseturn.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import lombok.Data

@Entity
@Data
data class PostEntity(
    @Id
    @GeneratedValue
    val id: Long,

    var title: String,

    @ManyToOne
    val user: UserEntity,

    @OneToMany
    var comments: List<CommentEntity>
)

