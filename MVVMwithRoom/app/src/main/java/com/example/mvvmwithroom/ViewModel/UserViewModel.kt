package com.example.mvvmwithroom.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithroom.Model.UserModel
import com.example.mvvmwithroom.Repository.UserRepository

class UserViewModel : ViewModel() {
    var liveData: LiveData<List<UserModel>>? = null

    fun show(context: Context): LiveData<List<UserModel>>? {
        liveData = UserRepository.show(context)
        return liveData
    }

    fun insert(context: Context, nama: String, prodi: String){
        UserRepository.insert(context,nama,prodi)
    }
}