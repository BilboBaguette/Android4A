package com.example.android4a.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface NierAPI {
    @get:GET("NierAutomata-API.json")
    val nierResponse: Call<RestNierAPIResponse>
}