package com.xxh.learn.sample.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import androidx.navigation.fragment.fragment
import com.xxh.learn.sample.MainListFragment
import com.xxh.learn.sample.compose.ComposeListFragment
import com.xxh.learn.sample.di.DIListFragment
import com.xxh.learn.sample.navigation.NavigationListFragment
import com.xxh.learn.sample.paging.PagingListFragment
import com.xxh.learn.sample.room.RoomListFragment
import com.xxh.learn.sample.sample.SampleListFragment
import com.xxh.learn.system.component.ComponentMainActivity

fun NavGraphBuilder.navGraph() {
    fragment<MainListFragment, NavDestinations.Main>()
    fragment<ComposeListFragment, NavDestinations.Compose>()
    fragment<DIListFragment, NavDestinations.DI>()
    fragment<RoomListFragment, NavDestinations.Room>()
    fragment<SampleListFragment, NavDestinations.Sample>()
    fragment<NavigationListFragment, NavDestinations.Navigation>()
    fragment<PagingListFragment, NavDestinations.Paging>()
    activity<NavDestinations.Component> {
        activityClass = ComponentMainActivity::class
    }
}