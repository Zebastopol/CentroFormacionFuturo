package com.example.centroformacionfuturo.data.room

import androidx.room.*

@Dao
interface CourseDao {

    @Query("SELECT * FROM courses")
    fun getAll() : List<CourseEntity>

    @Query("SELECT * FROM courses WHERE id = :lid")
    fun findById(lid: Int):CourseEntity

    @Query("DELETE FROM courses")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg courses:CourseEntity)

    @Delete
    fun delete(course:CourseEntity)
}