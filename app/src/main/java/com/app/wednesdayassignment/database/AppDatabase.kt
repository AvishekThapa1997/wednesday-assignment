package com.app.wednesdayassignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.wednesdayassignment.dao.SingerDao
import com.app.wednesdayassignment.pojo.Singer
import com.app.wednesdayassignment.typeconverters.Converters

@Database(entities = [Singer::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun singerDao(): SingerDao
}