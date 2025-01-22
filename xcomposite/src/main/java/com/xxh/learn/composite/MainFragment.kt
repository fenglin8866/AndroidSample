package com.xxh.learn.composite

import androidx.navigation.fragment.findNavController
import com.xxh.basic.ListBaseFragment

class MainFragment : ListBaseFragment() {

    override fun setData(): Array<String> {
        return arrayOf("schedule", "words","inventory")
    }

    override fun itemClickHandle(name: String) {
        val id: Int? = when (name) {
            "schedule" -> R.id.action_mainFragment_to_navigation_schedule
            "words" -> R.id.action_mainFragment_to_navigation_words
            "inventory" -> R.id.action_mainFragment_to_navigation_inventory
            else -> null
        }
        id?.let {
            findNavController().navigate(it)
        }
    }
}