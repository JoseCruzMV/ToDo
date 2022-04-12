package com.commonsware.todo

import androidx.recyclerview.widget.RecyclerView
import com.commonsware.todo.databinding.TodoRowBinding

class RosterRowHolder(
    private val binding: TodoRowBinding,
    val onCheckboxToggle: (ToDoModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ToDoModel) {
        binding.apply {
            isCompleted.isChecked = model.isCompleted
            isCompleted.setOnCheckedChangeListener { _, _ -> onCheckboxToggle(model)  }
            desc.text = model.description
        }
    }
}