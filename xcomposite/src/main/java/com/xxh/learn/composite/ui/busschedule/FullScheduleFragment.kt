package com.xxh.learn.composite.ui.busschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xxh.basic.BaseFragment
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentFullScheduleBinding
import com.xxh.learn.composite.ui.busschedule.viewmodels.ScheduleListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullScheduleFragment : BaseFragment<FragmentFullScheduleBinding>() {

    private lateinit var customAdapter: ScheduleAdapter

    //private val viewModel: ScheduleListViewModel by activityViewModels()

    private val viewModel: ScheduleListViewModel by hiltNavGraphViewModels(R.id.navigation_schedule)

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFullScheduleBinding {
        return FragmentFullScheduleBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        customAdapter = ScheduleAdapter {
            val directions =
                FullScheduleFragmentDirections.actionFullScheduleFragmentToStopScheduleFragment(it.stopName)
            findNavController().navigate(directions)
        }
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mBinding.recyclerView.layoutManager = layoutManager
        mBinding.recyclerView.adapter = customAdapter
        updateData()
    }

    private fun updateData() {
        viewModel.getFullSchedule().observe(viewLifecycleOwner) {
            customAdapter.submitList(it)
        }
    }

}