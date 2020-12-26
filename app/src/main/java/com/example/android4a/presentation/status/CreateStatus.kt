package com.example.android4a.presentation.status

import com.example.android4a.domain.entity.User

sealed class CreateStatus

data class CreateSuccess(val user: User) : CreateStatus()

object NoEmail : CreateStatus()

object InvalidEmail : CreateStatus()

object NoPassword : CreateStatus()

object DifferentPasswords : CreateStatus()

object UnkownError : CreateStatus()


