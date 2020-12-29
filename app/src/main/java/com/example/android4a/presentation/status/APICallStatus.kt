package com.example.android4a.presentation.status

import com.example.android4a.domain.entity.NierCharacter

sealed class APICallStatus

data class APICallSuccess(val charaList: List<NierCharacter>) : APICallStatus()

object APICallFailure : APICallStatus()