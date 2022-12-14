package com.example.centroformacionfuturo.data.model.network

import com.example.centroformacionfuturo.data.model.retrofit.Course
import com.example.centroformacionfuturo.data.room.CourseDao
import com.example.centroformacionfuturo.helper.CourseHelper
import com.example.centroformacionfuturo.mapper.CourseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val courseApiService: CourseApiService,
    private val courseDao: CourseDao
){
    suspend fun findAll():List<Course> {
        return withContext(Dispatchers.IO){
            val response = courseApiService.listCourses()
            if( response.isSuccessful){
                val courses = response.body() ?: emptyList()
                //borrar cache antigua
                courseDao.deleteAll()
                //cachear datos en BD
                courses.forEach { courseModel ->
                    courseDao.insertAll( CourseMapper.toEntity(courseModel))
                }
                courses
            } else {
                courseDao.getAll()
            }
        }
    }

   suspend fun findById(id: Int):Course{
        return withContext(Dispatchers.IO){
            val response = courseApiService.courseDetail(id)
            if ( response.isSuccessful){
                val course = response.body() ?: CourseHelper.emptyCoursesModel()

                //cachear en BD
                courseDao.insertAll(CourseMapper.toEntity(course))
                course
            } else {
                courseDao.findById(id)
            }
        }
   }
}