package com.commonsware.todo.ui.roster

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.commonsware.todo.R
import com.commonsware.todo.RosterAdapter
import com.commonsware.todo.databinding.TodoRosterBinding
import com.commonsware.todo.repo.ToDoModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class RosterListFragment : Fragment() {

    private val motor: RosterMotor by viewModel()
    private var binding: TodoRosterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

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

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            motor.states.collect { state ->
                adapter.submitList(state.items)

                binding?.apply {
                    loading.visibility = if(state.isLoaded) View.GONE else View.VISIBLE

                    when {
                        state.items.isEmpty() && state.isLoaded -> {
                            empty.visibility = View.VISIBLE
                            empty.setText(R.string.msg_empty)
                        }
                        else -> empty.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actions_roster, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.add -> {
                add()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun display(model: ToDoModel) {
        findNavController()
            .navigate(RosterListFragmentDirections.displayModel(model.id))
    }

    private fun add() {
        findNavController()
            .navigate(RosterListFragmentDirections.createModel(null))
    }
}