package com.xxh.learn.system.component.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.xxh.learn.system.component.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}