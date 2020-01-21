package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    private lateinit var taskRepository: FakeTestRepository
    private lateinit var tasksViewModel: TasksViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUpViewModle() {
        taskRepository = FakeTestRepository()
        val task1 = Task("Title1", "Destination1")
        val task2 = Task("Title2", "Destination2", true)
        val task3 = Task("Title2", "Destination3", true)
        taskRepository.addTask(task1, task2, task3)

        tasksViewModel = TasksViewModel(taskRepository)
    }

    /*@Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh TasksViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())


        val observer = Observer<Event<Unit>> {}

        try {
            //   Observe the live data forever
            tasksViewModel.newTaskEvent.observeForever(observer)

            // When adding a new task
            tasksViewModel.addNewTask()

            //  then new task event is trigger
            val value = tasksViewModel.newTaskEvent.value
            assertThat(value?.getContentIfNotHandled(), (not(nullValue())))

        } finally {
            tasksViewModel.newTaskEvent.removeObserver(observer)
        }

        // Then the new task event is triggered
    }*/

    @Test
    fun addNewTask_setsNewTaskEvent_withLiveDataUtil() {

        // Given a fresh TasksViewModel
        val tasksViewModel = TasksViewModel(taskRepository)

        // When adding a new task
        tasksViewModel.addNewTask()

//       Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled(), (not(nullValue())))
    }

   /* @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given a fresh ViewModel
        val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())


        // When the filter type is ALL_TASKS
        taskViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        // Then the "Add task" action is visible
        assertThat(taskViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))
    }*/
}