package com.uz.ustudy.model

data class ResponseCourses(
    val ok: Boolean = false,
    val message: String? = null,
    val data: List<Course>
)