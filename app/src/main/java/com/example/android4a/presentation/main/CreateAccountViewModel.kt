package com.example.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.presentation.status.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val createUserUseCase: CreateUserUseCase
): ViewModel() {
    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()

    fun onClickedCreate(emailUser: String, userPassword: String, verifPassword: String){
        val user = User(emailUser, userPassword)
        viewModelScope.launch(Dispatchers.IO) {
            val create = createUserUseCase.invoke(emailUser, userPassword, verifPassword)
            val createStatus = when{
                create.equals("NoEmail") -> NoEmail
                create.equals("InvalidEmail") -> InvalidEmail
                create.equals("NoPassword") -> NoPassword
                create.equals("DifferentPasswords") -> DifferentPasswords
                create.equals("Success") -> CreateSuccess(user)
                else -> UnkownError
            }

            withContext(Dispatchers.Main){
                createLiveData.value = createStatus
            }
        }
    }
}