package com.xxh.learn.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.xxh.learn.sample.compose.ComposeListFragment
import com.xxh.learn.sample.di.DIListFragment
import com.xxh.learn.sample.lang.LangListFragment
import com.xxh.learn.sample.navigation.NavigationListFragment
import com.xxh.learn.sample.paging.PagingListFragment
import com.xxh.learn.sample.room.RoomListFragment
import com.xxh.learn.sample.sample.SampleListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNav()
    }

    private fun initNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView_main) as NavHostFragment
        val navController=navHostFragment.navController
        navController.graph=navController.createGraph(
            startDestination = NavDestinations.Main
        ){
            fragment<MainListFragment,NavDestinations.Main>()
            fragment<ComposeListFragment,NavDestinations.Compose>()
            fragment<DIListFragment,NavDestinations.DI>()
            fragment<LangListFragment,NavDestinations.Lang>()
            fragment<RoomListFragment,NavDestinations.Room>()
            fragment<SampleListFragment,NavDestinations.Sample>()
            fragment<NavigationListFragment,NavDestinations.Navigation>()
            fragment<PagingListFragment,NavDestinations.Paging>()
        }
    }
}
