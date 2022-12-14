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
class CourseDetailViewModel @Inject constructor(val repository: CourseRepository): ViewModel(){

    val course = MutableLiveData<Course>()

    fun loadCourse(id: Int){
        viewModelScope.launch {
            val courseFromRepo = repository.findById(id)
            if (courseFromRepo != null){
                course.postValue(courseFromRepo)
            }
        }
    }
}