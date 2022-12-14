package com.example.centroformacionfuturo.data.model.network

import com.example.centroformacionfuturo.data.model.retrofit.CourseModel
import com.example.centroformacionfuturo.data.room.CourseDao
import com.example.centroformacionfuturo.helper.CourseHelper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class CourseRepositoryTest {

    private lateinit var courseApiService: CourseApiService
    private lateinit var courseDao: CourseDao
    private lateinit var repository: CourseRepository
    private lateinit var response: Response<List<CourseModel>>

    @Before
    fun setup(){
        courseApiService = mockk<CourseApiService>()
        courseDao = mockk<CourseDao>(relaxed = true)
        response = mockk<Response<List<CourseModel>>>()
        repository = CourseRepository(courseApiService, courseDao)
    }

    @Test
    fun `probar que se guarden en BD los datos de la API`() = runBlocking{
        //Config
        every { response.body() } returns listOf(CourseHelper.emptyCoursesModel())
        every { response.isSuccessful } returns true
        coEvery { courseApiService.listCourses() } returns response

        //Check
        assertEquals(repository.findAll().size, 1)

        //chequeo de invocaciones
        coVerify(exactly = 1) { courseDao.deleteAll() }
        coVerify(exactly = 1) { courseDao.insertAll(any()) }
        coVerify(exactly = 0) { courseDao.getAll() }

    }

    @Test
    fun `probar que los datos vengan de BD cuando la API falla`() = runBlocking{
        //Config
        every { response.body() } returns listOf()
        every { response.isSuccessful } returns false
        coEvery { courseApiService.listCourses() } returns response

        //Check
        repository.findAll()

        //chequeo de invocaciones
        coVerify(exactly = 0) { courseDao.deleteAll() }
        coVerify(exactly = 0) { courseDao.insertAll(any()) }
        coVerify(exactly = 1) { courseDao.getAll() }

    }

}