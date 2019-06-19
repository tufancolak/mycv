package com.johndoe.mycv.repository.model

data class Basics(
    val email: String,
    val label: String,
    val name: String,
    val phone: String,
    val picture: String,
    val profiles: List<Profile>,
    val summary: String,
    val website: String
)