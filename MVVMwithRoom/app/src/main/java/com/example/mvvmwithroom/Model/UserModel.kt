package com.example.mvvmwithroom.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name : String,
    var prodi : String
)