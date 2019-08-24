package me.indiq.dev.indiqme.model

import java.time.LocalDateTime

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val linkedin: String,
    val skills: List<Skill>,
    val phone: String,
    val address: Address,
    val creationDate: LocalDateTime
)
