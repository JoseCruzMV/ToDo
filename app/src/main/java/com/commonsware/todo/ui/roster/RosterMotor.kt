package com.commonsware.todo.ui.roster

import android.app.Application
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commonsware.todo.BuildConfig
import com.commonsware.todo.repo.FilterMode
import com.commonsware.todo.repo.ToDoModel
import com.commonsware.todo.repo.ToDoRepository
import com.commonsware.todo.report.RosterReport
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.File

data class RosterViewState(
    val items: List<ToDoModel> = listOf(),
    val isLoaded: Boolean = false,
    val filterMode: FilterMode = FilterMode.ALL,
)

sealed class Nav {
    data class ViewReport(val doc: Uri) : Nav()
    data class ShareReport(val doc: Uri) : Nav()
}

private const val AUTHORITY = BuildConfig.APPLICATION_ID + ".provider"

class RosterMotor(
    private val repo: ToDoRepository,
    private val report: RosterReport,
    private val context: Application,
    private val appScope: CoroutineScope,
): ViewModel() {
    private val _states = MutableStateFlow(RosterViewState())
    val states = _states.asStateFlow()

    private var job: Job? = null

    private val _navEvents = MutableSharedFlow<Nav>()
    val navEvents = _navEvents.asSharedFlow()

    init {
        load(FilterMode.ALL)
    }

    fun load(filterMode: FilterMode) {
        job?.cancel()

        job = viewModelScope.launch {
            repo.items(filterMode = filterMode).collect {
                _states.emit(RosterViewState(it, true, filterMode))
            }
        }
    }

    fun save(model: ToDoModel) {
        viewModelScope.launch {
            repo.save(model = model)
        }
    }

    fun saveReport(doc: Uri) {
        viewModelScope.launch {
            report.generate(content = _states.value.items, doc = doc)
            _navEvents.emit(Nav.ViewReport(doc))
        }
    }

    fun shareReport() {
        viewModelScope.launch {
            saveForSharing()
        }
    }

    private suspend fun saveForSharing() {
        withContext(Dispatchers.IO + appScope.coroutineContext) {
            val shared = File(context.cacheDir, "shared").also { it.mkdirs() }
            val reportFile = File(shared, "report.html")
            val doc = FileProvider.getUriForFile(context, AUTHORITY, reportFile)

            _states.value.let { report.generate(it.items, doc) }
            _navEvents.emit(Nav.ShareReport(doc))
        }
    }
}