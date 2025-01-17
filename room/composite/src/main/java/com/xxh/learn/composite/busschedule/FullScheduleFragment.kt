package com.xxh.learn.composite.busschedule

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.xxh.learn.composite.busschedule.viewmodels.ScheduleListViewModel
import com.xxh.learn.composite.databinding.FragmentFullScheduleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullScheduleFragment : Fragment() {
    private lateinit var customAdapter: ScheduleAdapter
    private var _binding: FragmentFullScheduleBinding? = null
    private val mBinding get() = _binding!!

    private val model: ScheduleListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindView(inflater, container)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      /*  customAdapter = ScheduleAdapter(it)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mBinding.recyclerView.layoutManager = layoutManager
        mBinding.recyclerView.adapter = customAdapter*/

        setData()
    }

    private fun setData() {
       model.getFullSchedule().observe(viewLifecycleOwner){
           it.forEach {schedule->
               Log.i("xxh11","schedule="+schedule.toString())
           }

       }
    }


    private fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFullScheduleBinding {
        return FragmentFullScheduleBinding.inflate(inflater, container, false)
    }


    private fun itemClickHandle(name: String) {

    }

    /**
     * Called when fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}