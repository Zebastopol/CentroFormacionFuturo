package com.example.centroformacionfuturo.di

import com.example.centroformacionfuturo.data.model.network.CourseApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun baseUrl():String{
        return "https://courses-fake-api.herokuapp.com/"
    }

    @Provides
    @Singleton
    fun retrofit(baseUrl:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun courseApi(retrofit: Retrofit):CourseApiService{
        return retrofit.create(CourseApiService::class.java)
    }
}