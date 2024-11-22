package com.xxh.learn.demo.component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.xxh.learn.demo.R
import com.xxh.learn.demo.databinding.FragmentSecondBasicViewBinding

class SecondBasicViewFragment : Fragment() {
    private var _binding: FragmentSecondBasicViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBasicViewBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.secondButton.setOnClickListener {
            findNavController().navigate(R.id.action_secondBasicViewFragment_to_firstBasicViewFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}