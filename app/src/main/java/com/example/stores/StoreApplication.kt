package com.example.stores

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class StoreApplication: Application() {
    companion object{
        lateinit var database: StoreDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,
            StoreDatabase::class.java,
            "StoreDatabase").build()
    }
}