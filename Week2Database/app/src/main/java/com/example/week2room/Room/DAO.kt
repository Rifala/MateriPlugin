package com.example.week2room.Room

import androidx.room.*

@Dao
interface DAO {

    @Insert
    suspend fun CreateData(entity : Entity)

    @Query("SELECT * FROM Entity")
    suspend fun ReadData():MutableList<Entity>

    @Query("SELECT * FROM Entity WHERE id=:id")
    suspend fun ReadDataById(id : Int) : MutableList<Entity>

    @Update
    suspend fun updateData(entity: Entity)

    @Delete
    suspend fun deleteData(entity: Entity)




}