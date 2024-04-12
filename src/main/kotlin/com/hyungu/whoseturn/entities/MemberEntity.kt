package com.hyungu.whoseturn.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.Getter
import lombok.Setter

@Entity(name = "Member")
@Getter
@Setter
data class MemberEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String
)

