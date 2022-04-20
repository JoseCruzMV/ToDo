package com.commonsware.todo.ui

import androidx.lifecycle.ViewModel
import com.commonsware.todo.repo.ToDoModel
import com.commonsware.todo.repo.ToDoRepository

class SingleModelMotor(
    private val repo: ToDoRepository,
    private val modelId: String?,
) : ViewModel() {
    fun getModel() = repo.find(modelId = modelId)

    fun save(model: ToDoModel) = repo.save(model = model)

    fun delete(model: ToDoModel) = repo.delete(model = model)
}