package com.example.centroformacionfuturo.ui.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.centroformacionfuturo.R
import com.example.centroformacionfuturo.adapter.COURSEID_MESSAGE
import com.example.centroformacionfuturo.databinding.ActivityCourseDetailBinding
import com.example.centroformacionfuturo.ui.viewmodel.CourseDetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding

    private val courseDetailViewModel: CourseDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseId = intent.getIntExtra(COURSEID_MESSAGE,0)

        courseDetailViewModel.loadCourse(courseId)

        courseDetailViewModel.course.observe(this, Observer { course ->
            with(binding) {
                tvDetalleTitulo.text = course.titulo
                tvDetalleDescripcion.text = course.descripcion
                tvSemanas.text = "Duración: ${course.semanas}"
                tvNivel.text = "Nivel: ${course.nivel}"
                tvBeca.text  = "Becas: ${course.beca}"
                tvModalidad.text = "Modalidad: ${course.modalidad}"
                tvInicio.text = "Inicio: ${course.comienza}"
                tvDetalleMatricula.text = "Valor: ${course.matricula}"
                Picasso.get().load(course.imagen).into(imgDetalle)
            }

            // evento boton comprar
            binding.btnSolicitar.setOnClickListener {
                val mailText = """
                Hola, 
                    
                Vi el curso ${course.titulo} de código ${course.id} y me gustaría que me 
                contactaran a este correo o al siguiente número telefónico ___________.
                
                Quedo atent@
                """.trimIndent()

                val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                    type = "msage/rfc822"
                    data = Uri.parse("mailto:")
                    val to:Array<String> = arrayOf("admisión@centrofuturo.cl")

                    putExtra(Intent.EXTRA_EMAIL, to)
                    putExtra(Intent.EXTRA_SUBJECT, "Solicito Información sobre este curso ${course.titulo} de código ${course.id}")
                    putExtra(Intent.EXTRA_TEXT, mailText)
                }

                startActivity(intentMail)
            }
        })
    }
}