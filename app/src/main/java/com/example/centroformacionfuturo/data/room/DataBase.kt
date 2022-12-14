package com.example.centroformacionfuturo.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CourseEntity::class], version = 4)
abstract class DataBase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}