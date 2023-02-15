package com.example.centroformacionfuturo.ui.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.centroformacionfuturo.adapter.CourseAdapter
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @LargeTest
    fun prueba_click_recycler_muestra_detalle(){
        Espresso.onView(withId(R.id.myRecycler))
            .perform(
                RecyclerViewActions.scrollToPosition<CourseAdapter.ViewHolder>(4)
            )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CourseAdapter.ViewHolder>(
                    2,
                    ViewActions.click()
                )
            )

        //Revisar que se cargue el juego
        Espresso.onView(withId(R.id.tvName))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.withText("Back end Web Development")
                )
            )
    }
}

annotation class LargeTest
