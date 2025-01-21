package com.xxh.learn.composite.ui.words

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.xxh.learn.composite.repository.WordRepository
import com.xxh.learn.composite.vo.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(private val repository: WordRepository) : ViewModel() {

    fun getAllWord(): LiveData<List<Word>> {
        return repository.getAllWord().asLiveData()
    }

    fun insert(word: Word) {
        viewModelScope.launch {
            repository.insert(word)
        }
    }
}