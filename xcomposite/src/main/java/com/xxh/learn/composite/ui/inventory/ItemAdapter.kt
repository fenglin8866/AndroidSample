package com.xxh.learn.composite.ui.inventory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.xxh.learn.composite.databinding.ItemItemBinding
import com.xxh.learn.composite.ui.common.BaseListAdapter
import com.xxh.learn.composite.vo.Item

class ItemAdapter(clickCallback: ((Item) -> Unit)) :
    BaseListAdapter<ItemItemBinding, Item>(clickCallback, COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.itemPrice == newItem.itemPrice &&
                        oldItem.itemName == newItem.itemName &&
                        oldItem.quantityInStock == newItem.quantityInStock
            }

        }
    }

    override fun initBindView(inflater: LayoutInflater, container: ViewGroup?): ItemItemBinding {
        return ItemItemBinding.inflate(inflater, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun bindData(binding: ViewBinding, entity: Item) {
        (binding as ItemItemBinding).apply {
            itemName.text = entity.itemName
            itemPrice.text = entity.getFormattedPrice()
            itemQuantity.text = entity.quantityInStock.toString()
        }
    }

}
