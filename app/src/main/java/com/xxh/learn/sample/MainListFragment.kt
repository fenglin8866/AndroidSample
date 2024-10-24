package com.xxh.learn.sample

import androidx.navigation.fragment.findNavController

import com.xxh.basic.ListBaseFragment


class MainListFragment : ListBaseFragment() {

    override fun setData(): Array<String> = arrayOf(
        "Lang",
        "Room",
        "DI",
        "Lifecycle",
        "Navigation",
        "Compose",
        "Sample",
    )

    override fun itemClickHandle(name: String) {
        val navDestination:Any? = when (name) {
            "Room" -> NavDestinations.Room
            "DI" -> NavDestinations.DI
            "Lang" -> NavDestinations.Lang
            "Compose" -> NavDestinations.Compose
            "Sample" -> NavDestinations.Sample
            else -> null
        }
        navDestination?.let {
            findNavController().navigate(navDestination)
        }
    }

}