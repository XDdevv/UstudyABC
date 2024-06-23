package com.uz.ustudy.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.uz.ustudy.db.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert // Malumotni yozadi
    suspend fun insertAll(list: List<CategoryEntity>)

    @Query("SELECT * FROM CategoryEntity") // malumot ni uqiydi
    suspend fun getAllCategories():Flow<CategoryEntity>
    @Query("DELETE FROM categoryentity") // malumot ni tozalaydi
    suspend fun clear()

}