package com.johndoe.mycv.repository.model

data class Work(
    val company: String,
    val endDate: String,
    val highlights: List<String>,
    val position: String,
    val startDate: String,
    val summary: String,
    val website: String
)