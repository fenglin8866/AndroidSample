package com.xxh.learn.fragment.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.xxh.learn.fragment.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}