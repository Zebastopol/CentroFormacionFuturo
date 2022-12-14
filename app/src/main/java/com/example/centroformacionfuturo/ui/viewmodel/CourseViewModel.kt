package com.example.centroformacionfuturo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.centroformacionfuturo.data.model.network.CourseRepository
import com.example.centroformacionfuturo.data.model.retrofit.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(val repository: CourseRepository): ViewModel(){

    val courses = MutableLiveData<List<Course>>()

    fun loadCourses(){
        viewModelScope.launch {
            val coursesFromRepo = repository.findAll()
            if (!coursesFromRepo.isNullOrEmpty()){
                courses.postValue(coursesFromRepo)
            }
        }
    }


}