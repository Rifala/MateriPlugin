package com.example.batch3.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.batch3.Model.DataName

class viewmodel : ViewModel() {

    var data : MutableLiveData<DataName> = MutableLiveData()
    private val result_data : LiveData<DataName> get() = data

    fun setData(dataName: DataName){
        data.value = dataName

    }
}