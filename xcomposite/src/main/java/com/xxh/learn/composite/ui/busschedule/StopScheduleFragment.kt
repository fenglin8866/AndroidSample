package com.xxh.learn.composite.ui.busschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.xxh.basic.BaseFragment
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentStopScheduleBinding
import com.xxh.learn.composite.ui.busschedule.viewmodels.ScheduleListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StopScheduleFragment : BaseFragment<FragmentStopScheduleBinding>() {

    //private val viewModel: ScheduleListViewModel by activityViewModels()
    private val viewModel: ScheduleListViewModel by hiltNavGraphViewModels(R.id.navigation_schedule)

    private val args:StopScheduleFragmentArgs by navArgs()

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentStopScheduleBinding {
        return FragmentStopScheduleBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        val adapter = ScheduleAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        mBinding.apply {
            recyclerViewStop.layoutManager = layoutManager
            recyclerViewStop.adapter = adapter
        }
        val stop= args.stopName
        viewModel.getStopSchedule(stop)?.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}