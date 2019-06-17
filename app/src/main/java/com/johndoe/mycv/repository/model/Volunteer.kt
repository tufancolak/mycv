package com.johndoe.mycv.repository.model

data class Volunteer(
    val endDate: String,
    val highlights: List<String>,
    val organization: String,
    val position: String,
    val startDate: String,
    val summary: String,
    val website: String
)