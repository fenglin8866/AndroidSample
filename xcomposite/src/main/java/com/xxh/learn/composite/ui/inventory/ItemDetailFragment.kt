package com.xxh.learn.composite.ui.inventory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.xxh.basic.BaseFragment
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentItemDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemDetailFragment : BaseFragment<FragmentItemDetailBinding>() {

    private val viewModel: ItemViewModel by hiltNavGraphViewModels(R.id.navigation_inventory)

    private val args: ItemDetailFragmentArgs by navArgs()

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemDetailBinding {
        return FragmentItemDetailBinding.inflate(inflater, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun setupViews() {
        viewModel.getItem(args.itemId).observe(this) {
            mBinding.apply {
                itemName.text = it.itemName
                itemPrice.text = it.getFormattedPrice()
                itemCount.text = it.quantityInStock.toString()
                deleteItem.setOnClickListener { _ ->
                    viewModel.deleteItem(it)
                    findNavController().navigateUp()
                }
            }
        }
    }

}
