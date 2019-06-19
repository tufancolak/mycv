package com.johndoe.mycv.repository.model

import android.os.Parcelable

data class Education(
    val area: String,
    val courses: List<String>,
    val endDate: String,
    val gpa: String,
    val institution: String,
    val startDate: String,
    val studyType: String
)