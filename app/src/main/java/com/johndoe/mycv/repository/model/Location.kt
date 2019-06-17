package com.johndoe.mycv.repository.model

data class Location(
    val address: String,
    val city: String,
    val countryCode: String,
    val postalCode: String,
    val region: String
)