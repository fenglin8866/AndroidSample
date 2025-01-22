package com.xxh.learn.composite.ui.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.xxh.basic.BaseFragment
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentWordListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordListFragment : BaseFragment<FragmentWordListBinding>() {

//    private val viewModel: WordViewModel by activityViewModels()
    private val viewModel: WordViewModel by hiltNavGraphViewModels(R.id.navigation_words)

    /*// ViewModel API available in navigation.navigation-fragment
    // The ViewModel is scoped to the `nav_graph` Navigation graph
    val viewModel2: WordViewModel by navGraphViewModels(R.id.navigation_words)

    // Equivalent navGraphViewModels code using the viewModels API
    val viewModel3: WordViewModel by viewModels(
        { findNavController().getBackStackEntry(R.id.navigation_words) }
    )*/

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