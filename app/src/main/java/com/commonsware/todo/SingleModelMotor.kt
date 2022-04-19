package com.commonsware.todo

import androidx.lifecycle.ViewModel

class SingleModelMotor(
    private val repo: ToDoRepository,
    private val modelId: String?,
) : ViewModel() {
    fun getModel() = repo.find(modelId = modelId)

    fun save(model: ToDoModel) = repo.save(model = model)
}