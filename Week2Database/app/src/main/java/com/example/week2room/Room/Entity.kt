package com.example.week2room.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var nama : String,
    var prodi : String
)