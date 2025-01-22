package com.xxh.learn.composite.ui.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.xxh.basic.BaseFragment
import com.xxh.learn.composite.R
import com.xxh.learn.composite.databinding.FragmentAddItemBinding
import com.xxh.learn.composite.vo.Item
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemAddFragment : BaseFragment<FragmentAddItemBinding>() {

    private val viewModel: ItemViewModel by hiltNavGraphViewModels(R.id.navigation_inventory)

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddItemBinding {
        return FragmentAddItemBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        mBinding.apply {
            saveAction.setOnClickListener {
                val item= Item(itemName=itemName.text.toString(),
                    itemPrice = itemPrice.text.toString().toDouble(),
                    quantityInStock = itemCount.text.toString().toInt())
                viewModel.addItem(item)
                findNavController().navigateUp()
            }
        }
    }

}