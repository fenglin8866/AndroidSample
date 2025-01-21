package com.xxh.learn.composite.ui.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentWordListBinding
import com.xxh.learn.composite.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordListFragment : BaseFragment<FragmentWordListBinding>() {

    private val viewModel: WordViewModel by activityViewModels()

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWordListBinding {
        return FragmentWordListBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        super.setupViews()
        val adapter = WordAdapter()
        mBinding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            fab.setOnClickListener {
                findNavController().navigate(R.id.action_wordListFragment_to_newWordFragment)
            }
        }

        viewModel.getAllWord().observe(this) {
            adapter.submitList(it)
        }
    }

}