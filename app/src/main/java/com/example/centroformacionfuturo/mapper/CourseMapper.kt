package com.example.centroformacionfuturo.mapper

import com.example.centroformacionfuturo.data.model.retrofit.Course
import com.example.centroformacionfuturo.data.room.CourseEntity

class CourseMapper {

    companion object{
        fun toEntity(course : Course): CourseEntity{
            with(course){
                return CourseEntity(
                    id, titulo,descripcionPrevia,descripcion,imagen,semanas,matricula,nivel,beca,modalidad,comienza
                )
            }
        }
    }
}