package com.example.centroformacionfuturo.data.model.retrofit

interface Course {

    val id: Int
    val titulo: String
    val descripcionPrevia: String?
    val descripcion: String?
    val imagen: String
    val semanas: Int?
    val matricula: String?
    val nivel: String?
    val beca: Boolean?
    val modalidad: String?
    val comienza: String
}