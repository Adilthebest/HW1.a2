package com.example.hw1a2.ui.list4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class List4ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

}