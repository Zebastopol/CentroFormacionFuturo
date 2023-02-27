package com.example.centroformacionfuturo.data.network

import com.example.centroformacionfuturo.data.model.CourseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CourseApiService {

    @GET("courses")
    suspend fun listCourses(): Response<List<CourseModel>>

    @GET("courses_details/{id}")
    suspend fun courseDetail(@Path("id") courseId: Int): Response<CourseModel>
}