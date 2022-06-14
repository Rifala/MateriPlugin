package com.example.mvvmwithroom.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmwithroom.Model.UserModel

@Dao
interface Dao {

    @Insert
    suspend fun insertData(userModel: UserModel)

    @Query("SELECT * FROM UserModel")
    fun getAllData() : LiveData<List<UserModel>>

}