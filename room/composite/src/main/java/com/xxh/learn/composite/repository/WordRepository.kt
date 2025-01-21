package com.xxh.learn.composite.repository

import androidx.annotation.WorkerThread
import com.xxh.learn.composite.db.WordDao
import com.xxh.learn.composite.vo.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository @Inject constructor (private val wordDao: WordDao) {

    fun getAllWord(): Flow<List<Word>> {
      return  wordDao.getAlphabetizedWords()
    }

    @WorkerThread
    suspend fun insert(word:Word){
        wordDao.insert(word)
    }
}