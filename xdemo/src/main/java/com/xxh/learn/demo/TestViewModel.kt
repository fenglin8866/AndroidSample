package com.xxh.learn.demo

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


class TestViewModel(private val app:Application, private val savedStateHandle: SavedStateHandle):ViewModel() {
    fun getApplication(): String {
        return app.toString()
    }

    fun setSavedTest(text: String) {
        savedStateHandle.set(SAVED_STATE_KEY, "")
    }

    fun getSavedTest(): String {
        return savedStateHandle.get(SAVED_STATE_KEY) ?: "xxh"
    }

    companion object{
        const val SAVED_STATE_KEY="xxh"

        val Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val savedStateHandle = extras.createSavedStateHandle()
                return TestViewModel(application, savedStateHandle) as T
            }
        }

        val Factory2: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[APPLICATION_KEY])
                val savedStateHandle = createSavedStateHandle()
                TestViewModel(application, savedStateHandle)
            }
        }

        fun providerFactory(a:String): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                    val application=checkNotNull(extras[APPLICATION_KEY])
                    val savedStateHandle=extras.createSavedStateHandle()
                    return TestViewModel(application,savedStateHandle) as T
                }
            }
        }

    }

}