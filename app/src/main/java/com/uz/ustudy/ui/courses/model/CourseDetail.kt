package com.uz.ustudy.ui.courses.model

data class CourseDetail(
    val id: Int,
    val courseName: String,
    val description: String,
    val ownerId: Int,
    val timestamp: Long,
    val courseBanner: String,
    val introVideo: String,
    val isFree: Boolean,
    val price: Double? = null
)
