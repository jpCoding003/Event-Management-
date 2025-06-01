package com.tops.eventmange.ui.vendors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VendorViewModel : ViewModel() {
    //Ignore
    private val _text = MutableLiveData<String>().apply {
        value = "This is vendor Fragment"
    }
    val text: LiveData<String> = _text
}