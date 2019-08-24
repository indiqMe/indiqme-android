package me.indiq.dev.indiqme.model

data class Address(
    val id: Long,
    val street: String,
    val number: String,
    val complement: String,
    val neighborhood: String,
    val postalCode: String,
    val city: String,
    val state: String,
    val country: String
)
