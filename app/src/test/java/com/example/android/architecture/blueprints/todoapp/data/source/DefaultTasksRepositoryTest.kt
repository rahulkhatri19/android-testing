package com.example.android.architecture.blueprints.todoapp.data.source

import com.example.android.architecture.blueprints.todoapp.data.Result
import com.example.android.architecture.blueprints.todoapp.data.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DefaultTasksRepositoryTest {
    private val task1 = Task("title1", "description1")
    private val task2 = Task("title2", "description2")
    private val task3 = Task("title3", "description3")

    //    private val remoteTasks = listOf(task1, task2).sortedBy { it.id }
    private val remoteTasks = listOf(task1, task2).sortedBy { it.id }
    private val localTasks = listOf(task3).sortedBy { it.id }
    private val newTasks = listOf(task3).sortedBy { it.id }

    private lateinit var taskRemoteDataSource: FakeDataSource
    private lateinit var taskLocalDataSource: FakeDataSource

    //  class under test
    private lateinit var taskRepository: DefaultTasksRepository

    @Before
    fun createRepository() {
        taskRemoteDataSource = FakeDataSource(remoteTasks.toMutableList())
        taskLocalDataSource = FakeDataSource(localTasks.toMutableList())
        // Get a reference to the class under test
        taskRepository = DefaultTasksRepository(
                //  this requires understanding more about coroutines + testing
                //  so we will keep this as Unconfined for now.
                taskRemoteDataSource, taskLocalDataSource, Dispatchers.Unconfined)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTasks_requestsAllTasksFromRemoteDataSource() = runBlockingTest {
        /* When tasks are requested from the tasks repository */
        val tasks = taskRepository.getTasks(true) as Result.Success

        // Then tasks are loaded from the remote data source
        assertThat(tasks.data, IsEqual(remoteTasks))
    }
}