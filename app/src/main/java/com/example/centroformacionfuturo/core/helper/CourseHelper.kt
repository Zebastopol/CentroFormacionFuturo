package com.example.centroformacionfuturo.core

import com.example.centroformacionfuturo.data.model.retrofit.CourseModel

class CourseHelper {

    companion object{
        fun emptyCoursesModel(): CourseModel{
            return CourseModel(
                0,
                "",
                "",
                "",
                "",
                0,
                "",
                "",
                false,
                "",
                ""
            )
        }
    }

}