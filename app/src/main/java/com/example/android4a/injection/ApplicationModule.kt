package com.example.android4a.injection

import android.content.Context
import androidx.room.Room
import com.example.android4a.data.local.LoginDatabase
import com.example.android4a.data.local.DatabaseDaoLogin
import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.usecase.*
import com.example.android4a.presentation.main.CreateAccountViewModel
import com.example.android4a.presentation.main.ListViewModel
import com.example.android4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get()) }
    factory { CreateAccountViewModel(get()) }
    factory { ListViewModel() }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBaseLogin(androidContext()) }
}

fun createDataBaseLogin(context: Context): DatabaseDaoLogin {
    val loginDatabase = Room.databaseBuilder(
        context,
        LoginDatabase::class.java, "database-name"
    ).build()
    return loginDatabase.dataBaseDao()
}