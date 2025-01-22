package com.xxh.learn.composite.repository

import com.xxh.learn.composite.db.ItemDao
import com.xxh.learn.composite.vo.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemDao: ItemDao) {

    fun getAllItem(): Flow<List<Item>> {
        return itemDao.getAllItem()
    }

    fun getItemById(id: Int): Flow<Item> {
        return itemDao.getItem(id)
    }

    suspend fun addItem(vararg items: Item) {
        itemDao.addItem(*items)
    }

    suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }

    suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

}