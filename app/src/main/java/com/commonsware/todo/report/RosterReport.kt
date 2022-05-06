package com.commonsware.todo.report

import android.content.Context
import android.net.Uri
import com.commonsware.todo.R
import com.commonsware.todo.repo.ToDoModel
import com.github.jknack.handlebars.Handlebars
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RosterReport(
    private val context: Context,
    engine: Handlebars,
    private val appScope: CoroutineScope,
) {
    private val template =
        engine.compileInline(context.getString(R.string.report_template))

    suspend fun generate(content: List<ToDoModel>, doc: Uri) {
        withContext(Dispatchers.IO + appScope.coroutineContext) {
            context.contentResolver.openOutputStream(doc, "rwt")?.writer()?.use { osw ->
                osw.write(template.apply(content))
                osw.flush()
            }
        }
    }
}