package com.example.centroformacionfuturo.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.centroformacionfuturo.adapter.CourseAdapter
import com.example.centroformacionfuturo.databinding.ActivityMainBinding
import com.example.centroformacionfuturo.ui.viewmodel.CourseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val courseViewModel: CourseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //SplashScreen
        /**splashScreen.setKeepOnScreenCondition{ true }
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()**/

        //RecyclerView
        val recyclerView = binding.myRecycler
        recyclerView.layoutManager = LinearLayoutManager(this)
        courseViewModel.loadCourses()

        //ObserverViewModel
        courseViewModel.courses.observe(this, Observer{ courses ->
            binding.myRecycler.adapter = CourseAdapter(courses)
        })
    }
}