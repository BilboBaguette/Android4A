package com.example.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUseruseCase
import kotlinx.coroutines.launch

class MainViewModel(
    val createUseruseCase: CreateUseruseCase
): ViewModel() {
    val counter: MutableLiveData<Int> = MutableLiveData()

    init{
        counter.value = 0
    }

    fun onClickedIncrement(emailUser: String){
        viewModelScope.launch{
            createUseruseCase.invoke(User(emailUser))
        }
        //counter.value = (counter.value ?: 0) + 1
    }
}