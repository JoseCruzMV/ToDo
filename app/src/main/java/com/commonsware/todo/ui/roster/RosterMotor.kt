package com.commonsware.todo.ui.roster

import androidx.lifecycle.ViewModel
import com.commonsware.todo.repo.ToDoModel
import com.commonsware.todo.repo.ToDoRepository

class RosterMotor(
    private val repo: ToDoRepository
): ViewModel() {
    fun getItems() = repo.items

    fun save(model: ToDoModel) {
        repo.save(model)
    }
}