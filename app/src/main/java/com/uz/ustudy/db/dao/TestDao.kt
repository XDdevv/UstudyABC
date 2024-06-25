package com.uz.ustudy.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uz.ustudy.db.test.Test

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTest(test: Test)

    @Query("SELECT * FROM Test")
    suspend fun getTests() : List<Test>

}