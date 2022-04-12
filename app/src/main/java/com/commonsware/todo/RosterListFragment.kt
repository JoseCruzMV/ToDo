package com.commonsware.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.commonsware.todo.databinding.TodoRosterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RosterListFragment : Fragment() {

    private val motor: RosterMotor by viewModel()
    private var binding: TodoRosterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return TodoRosterBinding.inflate(inflater, container, false)
            .also { binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RosterAdapter(
            layoutInflater,
            onCheckboxToggle = {
                motor.save(it.copy(isCompleted = !it.isCompleted))
            },
            onRowClick = ::display
        )

        binding?.items?.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        adapter.submitList(motor.items)
        binding?.empty?.visibility = View.GONE
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun display(model: ToDoModel) {
        findNavController()
            .navigate(RosterListFragmentDirections.displayModel(model.id))
    }
}