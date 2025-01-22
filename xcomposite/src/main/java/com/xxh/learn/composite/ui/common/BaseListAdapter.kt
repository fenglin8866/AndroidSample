package com.xxh.learn.composite.ui.common

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


abstract class BaseListAdapter<T : ViewBinding, E>(
    private val clickCallback: ((E) -> Unit)? = null,
    diffCallback: DiffUtil.ItemCallback<E>
) : ListAdapter<E, BaseListAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = initBindView(LayoutInflater.from(parent.context), parent)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickCallback) { binding, data ->
            bindData(binding, data)
        }
    }

    abstract fun initBindView(inflater: LayoutInflater, container: ViewGroup?): T

    abstract fun bindData(binding: ViewBinding, entity: E)

    class ViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SimpleDateFormat")
        fun <T> bind(
            entity: T,
            clickCallback: ((T) -> Unit)? = null,
            callback: (ViewBinding, T) -> Unit
        ) {
            binding.apply {
                callback(this, entity)
                itemView.setOnClickListener {
                    clickCallback?.let { callback ->
                        callback(entity)
                    }
                }
            }
        }
    }

}
