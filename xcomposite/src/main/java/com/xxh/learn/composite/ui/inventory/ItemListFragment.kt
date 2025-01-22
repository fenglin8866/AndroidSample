package com.xxh.learn.composite.ui.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xxh.basic.BaseFragment
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentItemListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListFragment : BaseFragment<FragmentItemListBinding>() {

    private val viewModel: ItemViewModel by hiltNavGraphViewModels(R.id.navigation_inventory)

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemListBinding {
        return FragmentItemListBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        val adapter = ItemAdapter {
            val directions =
                ItemListFragmentDirections.actionItemListFragmentToItemDetailFragment(it.id)
            findNavController().navigate(directions)
        }
        val manager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        mBinding.apply {
            recyclerView.layoutManager = manager
            recyclerView.adapter = adapter
            floatingActionButton.setOnClickListener {
                findNavController().navigate(R.id.action_itemListFragment_to_itemAddFragment)
            }
        }

        viewModel.getAllItem().observe(this) {
            adapter.submitList(it)
        }
    }

}
