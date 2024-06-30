package com.uz.ustudy.model

data class User(
    val id: Int? = null,
    var name: String? = null,
    var phone: String? = null,
    var password: String? = null,
    var title: String? = null,
    var guid: String? = null,
    var image: String? = null,
    var diamonds: Int? = null,
    var createdAt: Long? = null
)
