package com.xxh.learn.system.component

import android.content.Intent
import com.xxh.basic.ListBaseActivity
import com.xxh.learn.system.component.activity.BasicViewsActivity
import com.xxh.learn.system.component.activity.BottomNavigationViewsActivity
import com.xxh.learn.system.component.activity.ComposeActivity
import com.xxh.learn.system.component.activity.FragmentActivity
import com.xxh.learn.system.component.activity.FullscreenActivity
import com.xxh.learn.system.component.activity.LoginActivity
import com.xxh.learn.system.component.activity.NavigationDrawerViewsActivity
import com.xxh.learn.system.component.activity.PrimaryItemDetailHostActivity
import com.xxh.learn.system.component.activity.ResponsiveViewsActivity
import com.xxh.learn.system.component.activity.ScrollingActivity
import com.xxh.learn.system.component.activity.SettingsActivity
import com.xxh.learn.system.component.activity.TabbedViewsActivity

class ComponentMainActivity : ListBaseActivity() {
    override fun setData(): Array<String> = arrayOf(
        "ComposeActivity",
        "BasicViewsActivity",
        "FullscreenActivity",
        "LoginActivity",
        "SettingsActivity",
        "ScrollingActivity",
        "FragmentActivity",
        "TabbedViewsActivity",
        "BottomNavigationViewsActivity",
        "NavigationDrawerViewsActivity",
        "ResponsiveViewsActivity",
        "PrimaryItemDetailHostActivity",
    )

    override fun setClickIntent(name: String): Intent? {
        val clazz: Class<*>? = when (name) {
            "ComposeActivity" -> ComposeActivity::class.java
            "BasicViewsActivity" -> BasicViewsActivity::class.java
            "FullscreenActivity" -> FullscreenActivity::class.java
            "LoginActivity" -> LoginActivity::class.java
            "SettingsActivity" -> SettingsActivity::class.java
            "ScrollingActivity" -> ScrollingActivity::class.java
            "FragmentActivity" -> FragmentActivity::class.java
            "TabbedViewsActivity" -> TabbedViewsActivity::class.java
            "BottomNavigationViewsActivity" -> BottomNavigationViewsActivity::class.java
            "NavigationDrawerViewsActivity" -> NavigationDrawerViewsActivity::class.java
            "ResponsiveViewsActivity" -> ResponsiveViewsActivity::class.java
            "PrimaryItemDetailHostActivity" -> PrimaryItemDetailHostActivity::class.java
            else -> null
        }
       return Intent(this,clazz)
    }

}