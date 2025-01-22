package com.xxh.learn.composite.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.xxh.learn.composite.vo.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("select * from item")
    fun getAllItem(): Flow<List<Item>>

    /**
     * todo
     * 为什么从数据库中查找，
     * 1、不直接从内存getAllItem获取。而且从数据库中查找很可能比内存耗时高。
     * 2、或参数传递过去
     *
     */
    @Query("select * from item where id=:id")
    fun getItem(id: Int): Flow<Item>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(vararg items: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)
}