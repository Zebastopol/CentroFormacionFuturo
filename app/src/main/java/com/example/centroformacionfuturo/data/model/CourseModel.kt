package com.example.centroformacionfuturo.data.model

import com.example.centroformacionfuturo.data.model.retrofit.Course
import com.google.gson.annotations.SerializedName

data class CourseModel(
    @SerializedName("id") override val id: Int,
    @SerializedName("title") override val titulo: String,
    @SerializedName("previewDescription") override val descripcionPrevia: String?,
    @SerializedName("description") override val descripcion: String?,
    @SerializedName("image") override val imagen: String,
    @SerializedName("weeks") override val semanas: Int?,
    @SerializedName("tuition") override val matricula: String?,
    @SerializedName("minimumSkill") override val nivel: String?,
    @SerializedName("scholarshipsAvailable") override val beca: Boolean?,
    @SerializedName("modality") override val modalidad: String?,
    @SerializedName("start") override val comienza: String

): Course