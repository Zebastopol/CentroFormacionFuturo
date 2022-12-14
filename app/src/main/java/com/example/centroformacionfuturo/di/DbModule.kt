package com.example.centroformacionfuturo.di

import android.content.Context
import androidx.room.Room
import com.example.centroformacionfuturo.data.room.CourseDao
import com.example.centroformacionfuturo.data.room.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun dataBase(@ApplicationContext context: Context):DataBase{
        return Room
            .databaseBuilder(context, DataBase::class.java,"courses-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun courseDao(db:DataBase) : CourseDao {
        return db.courseDao()
    }
}