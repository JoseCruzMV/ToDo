package com.commonsware.todo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainDispatcherRule(paused: Boolean) : TestWatcher() {
    val dispatcher =
        TestCoroutineDispatcher().apply { if (paused) pauseDispatcher() }

    override fun starting(description: Description?) {
        super.starting(description)

        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)

        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }


}