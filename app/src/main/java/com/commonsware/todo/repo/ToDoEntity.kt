package com.commonsware.todo.repo

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import java.util.*

@Entity(tableName = "todos", indices = [ Index(value = ["id"]) ])
data class ToDoEntity(
    val description: String,
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val notes: String = "",
    val createdOn: Instant = Instant.now(),
    val isCompleted: Boolean = false
) {
    constructor(model: ToDoModel) : this(
        id = model.id,
        description = model.description,
        isCompleted = model.isCompleted,
        notes = model.notes,
        createdOn = model.createdOn
    )

    fun toModel(): ToDoModel {
        return ToDoModel(
            id = id,
            description = description,
            isCompleted = isCompleted,
            notes = notes,
            createdOn = createdOn
        )
    }

    @Dao
    interface Store {
        @Query("SELECT * FROM todos ORDER BY  description")
        fun all(): Flow<List<ToDoEntity>>

        @Query("SELECT * FROM todos WHERE id = :modelId")
        fun find(modelId: String?): Flow<ToDoEntity>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun save(vararg entities: ToDoEntity)

        @Delete
        suspend fun delete(vararg entities: ToDoEntity)
    }
}