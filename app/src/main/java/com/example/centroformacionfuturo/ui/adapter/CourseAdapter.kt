package com.example.centroformacionfuturo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.centroformacionfuturo.data.model.retrofit.Course
import com.example.centroformacionfuturo.databinding.CourseItemBinding
import com.example.centroformacionfuturo.ui.view.CourseDetailActivity
import com.squareup.picasso.Picasso

const val COURSEID_MESSAGE = "com.example.centroformacionfuturo.COURSEID"

class CourseAdapter(private val data:List<Course>) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    class ViewHolder(val binding:CourseItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = data.get(position)
        with(holder.binding){
            tvTitulo.text = "Nombre: ${course.titulo}"
            tvDesCorta.text= course.descripcionPrevia
            tvSemanas.text= "Duración: ${course.semanas}"
            tvComienza.text="Inicia: ${course.comienza}"
            Picasso.get()
                .load(course.imagen)
                .resize(400,380)
                .into(imageView)
        }
        holder.binding.root.setOnClickListener(View.OnClickListener{
            val intent = Intent(it.context, CourseDetailActivity::class.java).apply {
                putExtra(COURSEID_MESSAGE, course.id)
            }
            it.context.startActivity(intent)
        })
    }





    override fun getItemCount(): Int {
        return data.size
    }


}
