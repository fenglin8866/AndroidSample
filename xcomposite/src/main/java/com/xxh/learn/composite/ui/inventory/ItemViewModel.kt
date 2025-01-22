package com.xxh.learn.composite.ui.inventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.xxh.learn.composite.repository.ItemRepository
import com.xxh.learn.composite.vo.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: ItemRepository) : ViewModel() {

    fun getAllItem(): LiveData<List<Item>> {
        return repository.getAllItem().asLiveData()
    }

    fun getItem(id: Int): LiveData<Item> {
        return repository.getItemById(id).asLiveData()
    }

    fun addItem(item: Item) {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun updateItem(item: Item) {
        viewModelScope.launch {
            repository.updateItem(item)
        }
    }
}