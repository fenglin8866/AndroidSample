package com.xxh.learn.sample.navigation

import android.content.Intent
import com.android.samples.donuttracker.DonutMainActivity
import com.example.android.navigationadvancedsample.NavigationAdvancedActivity
import com.example.android.navigationsample.NavigationBasicActivity
import com.example.wordsapp.WordsMainActivity
import com.xxh.basic.ListBaseFragment
import com.xxh.learn.fragment.NavigationFragmentActivity


class NavigationListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "Codelab之Fragment和Navigation组件",
        "NavigationFragment",
        "NavigationBasic",
        "NavigationAdvanced",
        "NavigationMADSkills",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "Codelab之Fragment和Navigation组件" -> WordsMainActivity::class.java
            "NavigationFragment" -> NavigationFragmentActivity::class.java
            "NavigationBasic" -> NavigationBasicActivity::class.java
            "NavigationAdvanced" -> NavigationAdvancedActivity::class.java
            "NavigationMADSkills" -> DonutMainActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}