package com.uz.ustudy.model

data class ResponseBooks(
    val ok: Boolean = false,
    val message: String? = null,
    val data: List<Book>
)