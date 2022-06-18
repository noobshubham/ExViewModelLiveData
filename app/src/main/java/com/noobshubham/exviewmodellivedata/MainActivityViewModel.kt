package com.noobshubham.exviewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var number: Int = 0

    val currentNumber: MutableLiveData<Int> = MutableLiveData()
    val currentBoolean: MutableLiveData<Boolean> = MutableLiveData()

}