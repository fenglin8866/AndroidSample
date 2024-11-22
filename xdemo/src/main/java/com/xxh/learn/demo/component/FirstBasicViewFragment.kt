package com.xxh.learn.demo.component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.xxh.learn.demo.R
import com.xxh.learn.demo.databinding.FragmentFirstBasicViewBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FirstBasicViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstBasicViewFragment : Fragment() {
    private var _binding: FragmentFirstBasicViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBasicViewBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstBasicViewFragment_to_secondBasicViewFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}