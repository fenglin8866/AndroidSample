package com.xxh.learn.composite.ui.busschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xxh.learn.composite.ui.busschedule.viewmodels.ScheduleListViewModel
import com.xxh.learn.composite.databinding.FragmentFullScheduleBinding
import com.xxh.learn.composite.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullScheduleFragment : BaseFragment<FragmentFullScheduleBinding>() {

    private lateinit var customAdapter: ScheduleAdapter

    private val model: ScheduleListViewModel by activityViewModels()

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
        model.getFullSchedule().observe(viewLifecycleOwner) {
            customAdapter.submitList(it)
        }
    }

}