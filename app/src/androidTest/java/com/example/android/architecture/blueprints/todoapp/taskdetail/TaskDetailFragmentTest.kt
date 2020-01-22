package com.example.android.architecture.blueprints.todoapp.taskdetail

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class TaskDetailFragmentTest {

    @Test
    fun activeTaskDetails_DisplayedInUi(){
        // GIVEN - Add active (incomplete) task to the DB
        val activeTask = Task("Test 1", "AndroidX test", false)

        // WHEN - Details fragment launched to display task
        val bundle = TaskDetailFragmentArgs(activeTask.id).toBundle()
        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)
        Thread.sleep(2000)  //  to make fragment wait for 2 second

//        val bundle = TaskDetailFragmentArgs(activeTask.id).toBundle()
//        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)
//        Thread.sleep(2000)
    }
}