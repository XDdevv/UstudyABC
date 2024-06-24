package com.uz.ustudy.db.test

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Test {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}