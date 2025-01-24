package com.xxh.learn.composite.other

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(diffCallback: DiffUtil.ItemCallback<User>) :
    PagingDataAdapter<User, UserAdapter.UserViewHolder>(diffCallback) {

    class UserViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent) {

        fun bind(user: User?) {

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        return UserViewHolder(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        // Note that item can be null. ViewHolder must support binding a
        // null item as a placeholder.
        holder.bind(item)
    }
}