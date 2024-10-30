package com.xxh.learn.fragment.sample.demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContactsViewModel:ViewModel() {
    val uiState: StateFlow<ContactsUiState>
        get() = _state
    private val _state = MutableStateFlow(ContactsUiState())
}