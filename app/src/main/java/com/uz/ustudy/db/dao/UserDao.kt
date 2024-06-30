package com.uz.ustudy.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uz.ustudy.db.test.Test
import com.uz.ustudy.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM Test")
    suspend fun getUsers(): List<User>

    @Delete
    fun removeUser(user: User)
}