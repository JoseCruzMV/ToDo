package com.commonsware.todo.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.OkHttpClient
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.empty
import org.hamcrest.Matchers.equalTo
import org.hamcrest.collection.IsIterableContainingInOrder.contains


import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ToDoRepositoryTest {
    @get:Rule
    val instaTaskExecutorRule = InstantTaskExecutorRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val db = ToDoDatabase.newTestInstance(context)
    private val remoteDataSource = ToDoRemoteDataSource(OkHttpClient())

    @Test
    fun cadAddItems() = runBlockingTest {
        val underTest = ToDoRepository(db.todoStore(), this, remoteDataSource)
        val results = mutableListOf<List<ToDoModel>>()

        val itemsJob = launch {
            underTest.items().collect { results.add(it) }
        }

        assertThat(results.size, equalTo(1))
        assertThat(results[0], empty())

        val testModel = ToDoModel("test model")

        underTest.save(testModel)

        assertThat(results.size, equalTo(2))
        assertThat(results[1], contains(testModel))
        assertThat(underTest.find(testModel.id).first(), equalTo(testModel))

        itemsJob.cancel()
    }

    @Test
    fun canModifyItems() = runBlockingTest {
        val underTest = ToDoRepository(db.todoStore(), this, remoteDataSource)
        val testModel = ToDoModel("Test Model")
        val replacement = testModel.copy(notes = "This is the replacement")
        val results = mutableListOf<List<ToDoModel>>()

        val itemsJobs = launch {
            underTest.items().collect { results.add(it) }
        }

        assertThat(results[0], empty())

        underTest.save(testModel)

        assertThat(results[1], contains(testModel))

        underTest.save(replacement)

        assertThat(results[2], contains(replacement))

        itemsJobs.cancel()
    }

    @Test
    fun canRemoveItems() = runBlockingTest {
        val underTest = ToDoRepository(db.todoStore(), this, remoteDataSource)
        val testModel = ToDoModel("Test Model")
        val results = mutableListOf<List<ToDoModel>>()

        val itemsJob = launch {
            underTest.items().collect { results.add(it) }
        }

        assertThat(results[0], empty())

        underTest.save(testModel)

        assertThat(results[1], contains(testModel))

        underTest.delete(testModel)

        assertThat(results[2], empty())

        itemsJob.cancel()
    }
}