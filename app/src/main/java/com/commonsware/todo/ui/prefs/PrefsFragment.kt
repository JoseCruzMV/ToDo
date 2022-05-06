package com.commonsware.todo.ui.prefs

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.commonsware.todo.R

class PrefsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.prefs, rootKey)
    }
}