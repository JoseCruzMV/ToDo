package com.commonsware.todo.ui

import com.commonsware.todo.MainDispatcherRule
import com.commonsware.todo.repo.ToDoModel
import com.commonsware.todo.repo.ToDoRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SingleModelMotorTest {
  @get:Rule
  val mainDispatcherRule = MainDispatcherRule(paused = true)

  private val testModel = ToDoModel("This is a test")

  private val repo: ToDoRepository = mock {
    on { find(testModel.id) } doReturn flowOf(testModel)
  }

  private lateinit var underTest: SingleModelMotor

  @Before
  fun setUp() {
    underTest = SingleModelMotor(repo, testModel.id)
  }

  @Test
  fun `initial state`() {
    mainDispatcherRule.dispatcher.runCurrent()

    runBlocking {
      val item = underTest.states.first().item

      assertEquals(testModel, item)
    }
  }

  @Test
  fun `actions pass through to repo`() {
    val replacement = testModel.copy("other note")

    underTest.save(replacement)
    mainDispatcherRule.dispatcher.runCurrent()

    runBlocking { verify(repo).save(replacement) }

    underTest.delete(replacement)
    mainDispatcherRule.dispatcher.runCurrent()

    runBlocking { verify(repo).delete(replacement) }
  }
}