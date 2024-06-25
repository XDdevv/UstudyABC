package com.uz.ustudy.db.test

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String
)