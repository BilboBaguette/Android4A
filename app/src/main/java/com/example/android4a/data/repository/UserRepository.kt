package com.example.android4a.data.repository

import com.example.android4a.data.local.DatabaseDaoLogin
import com.example.android4a.data.local.models.toData
import com.example.android4a.data.local.models.toEntity
import com.example.android4a.domain.entity.User

class UserRepository(
    private val databaseDaoLogin: DatabaseDaoLogin
) {

    fun createUser(emailUser: String, userPassword: String, verifPassword: String): String{
        when{
            emailUser == "" -> return "NoEmail"
            !emailUser.contains("@") || !emailUser.contains(".") -> return "InvalidEmail"
            userPassword == "" -> return "NoPassword"
            userPassword != verifPassword -> return "DifferentPasswords"
            getUser(emailUser, userPassword) != null -> return "ExistingAccount"
        }
        val user = User(emailUser, userPassword)
        databaseDaoLogin.insert(user.toData())
        return "Success"
    }

    fun getUser(email: String, password: String): User? {
        val userLocal = databaseDaoLogin.findByName(email, password)
        return userLocal?.toEntity()
    }
}