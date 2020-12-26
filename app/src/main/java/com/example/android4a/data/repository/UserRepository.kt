package com.example.android4a.data.repository

import android.widget.Toast
import com.example.android4a.data.local.DatabaseDao
import com.example.android4a.data.local.models.toData
import com.example.android4a.data.local.models.toEntity
import com.example.android4a.domain.entity.User
import com.example.android4a.presentation.status.DifferentPasswords

class UserRepository(
    private val databaseDao: DatabaseDao
) {

    suspend fun createUser(emailUser: String, userPassword: String, verifPassword: String): String{
        when{
            emailUser == "" -> return "NoEmail"
            !emailUser.contains("@") || !emailUser.contains(".") -> return "InvalidEmail"
            userPassword == "" -> return "NoPassword"
            userPassword != verifPassword -> return "DifferentPasswords"
        }
        val user = User(emailUser, userPassword)
        databaseDao.insert(user.toData())
        return "Success"
    }

    fun getUser(email: String, password: String): User? {
        val userLocal = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }
}