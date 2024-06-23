package com.uz.ustudy.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val hash: String,
    val elementCount:String? = null
)
