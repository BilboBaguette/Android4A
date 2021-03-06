package com.example.android4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android4a.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class LoginDatabase : RoomDatabase() {
    abstract fun dataBaseDao(): DatabaseDaoLogin
}