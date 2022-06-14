package com.example.week2room.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Entity::class],
    version = 1
)
abstract class SetupRoomDB : RoomDatabase() {

    abstract fun dao (): DAO
    companion object {

        @Volatile private var instance : SetupRoomDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SetupRoomDB::class.java,
            "DB_Room"
        ).build()

    }
}