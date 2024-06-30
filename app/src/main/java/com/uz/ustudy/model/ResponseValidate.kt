package com.uz.ustudy.model

data class ResponseValidate(
    val ok: Boolean?=null,
    val message: String?=null,
    val user: User?=null
)