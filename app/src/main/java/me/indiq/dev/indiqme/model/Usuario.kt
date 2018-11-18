package me.indiq.dev.indiqme.model

data class Usuario(
    val name: String,
    val email: String,
    val street: String,
    val number: String,
    val complement: String,
    val neighborhood: String,
    val postalCode: String,
    val city: String,
    val state: String,
    val country: String,
    val linkedin: String,
    val phone: String,
    val password: String
)