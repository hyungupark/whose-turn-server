package com.hyungu.whoseturn.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.Data

@Entity(name = "Member")
@Data
data class MemberEntity(
    @Id
    @GeneratedValue
    val id: Long? = null,
    var name: String,
)

