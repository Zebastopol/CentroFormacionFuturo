package com.example.centroformacionfuturo.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.centroformacionfuturo.data.model.retrofit.Course

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey override val id:Int,
    override val titulo:String,
    override val descripcionPrevia:String?,
    override val descripcion:String?,
    override val imagen:String,
    override val semanas:Int?,
    override val matricula:String?,
    override val nivel:String?,
    override val beca:Boolean?,
    override val modalidad:String?,
    override val comienza:String
): Course