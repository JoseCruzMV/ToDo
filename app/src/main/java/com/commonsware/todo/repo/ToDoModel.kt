package com.commonsware.todo.repo

import java.time.Instant
import java.util.UUID


data class ToDoModel(
    val description: String,
    val id: String = UUID.randomUUID().toString(),
    val isCompleted: Boolean = false,
    val notes: String = "",
    val createdOn: Instant = Instant.now(),
) {
}