package com.commonsware.todo.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.commonsware.todo.R
import kotlinx.coroutines.NonCancellable.cancel

enum class ErrorScenario { Import, None }

class ErrorDialogFragment : DialogFragment() {
    private val args: ErrorDialogFragmentArgs by navArgs()

    companion object {
        const val KEY_RETRY = "retryRequested"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle(args.title)
            .setMessage(args.message)
            .setPositiveButton(R.string.retry) { _, _ -> onRetryRequest() }
            .setNegativeButton(R.string.cancel) { _, _ ->  }
            .create()
    }

    private fun onRetryRequest() {
        findNavController()
            .previousBackStackEntry?.savedStateHandle?.set(KEY_RETRY, args.scenario)
    }
}