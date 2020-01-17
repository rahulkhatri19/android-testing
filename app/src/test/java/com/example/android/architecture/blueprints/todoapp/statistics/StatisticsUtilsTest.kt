package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompleteStatus_zeroComplete_returnZeroHundred() {
//        Given total 1 task: 0 completed task and 1 active task
        val task = listOf(Task("title", "description", false))
//        When you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(task)
//        Then there are 100% active task and 0% complete task
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

//     Hamcrest library of Matchers
    @Test
    fun getActiveAndCompleteStatus_zeroComplete_returnZeroHundredHamcrest() {

//        Given total 1 task: 0 completed task and 1 active task
        val task = listOf(Task("title", "description", false))

//        When you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(task)

//        Then there are 100% active task and 0% complete task
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    // total 5 task: 2 completed task and 3 active task
//    by calculation 40% complete task and 60% active task

    @Test
    fun getThreeActiveTask_andTwoCompletedTask() {
        val task = listOf(
                Task("title", "description", false),
                Task("title2", "description2", true),
                Task("title3", "description3", false),
                Task("title4", "description4", true),
                Task("title5", "description5", false))
        val result = getActiveAndCompletedStats(task)
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    //    empty task
//    by calculation 0% active task and 0% complete task
    @Test
    fun getActiveTask_andCompletedTask_emptyList() {
        val task = emptyList<Task>()
        val result = getActiveAndCompletedStats(task)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    //    null task
//    by calculation 0% active task and 0% complete task
    @Test
    fun getActiveTask_andCompletedTask_nullList() {
        val task = null
        val result = getActiveAndCompletedStats(task)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}