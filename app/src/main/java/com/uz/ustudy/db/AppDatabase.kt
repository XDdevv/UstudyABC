package com.uz.ustudy.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uz.ustudy.app.UstudyApp
import com.uz.ustudy.db.dao.TestDao
import com.uz.ustudy.db.test.Test


@Database(
    entities = [Test::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun testDao(): TestDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    UstudyApp.application,
                    AppDatabase::class.java,
                    "ustudy_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}