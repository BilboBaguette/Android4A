package com.example.android4a.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4a.data.remote.NierAPI
import com.example.android4a.data.remote.RestNierAPIResponse
import com.example.android4a.presentation.status.*
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel(
): ViewModel() {
    val apiLiveData: MutableLiveData<APICallStatus> = MutableLiveData()
    private val BASE_URL = "https://raw.githubusercontent.com/BilboBaguette/ProjAndroid3A/master/"

    fun makeAPICall(){
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val nierApi = retrofit.create(NierAPI::class.java)
        val call: Call<RestNierAPIResponse>? = nierApi?.nierResponse
        if (call != null) {
            call.enqueue(object : Callback<RestNierAPIResponse?> {
                override fun onResponse(
                    call: Call<RestNierAPIResponse?>?,
                    response: Response<RestNierAPIResponse?>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val charaList = response.body()!!.results
                        apiLiveData.value = APICallSuccess(charaList)
                    }
                }
                override fun onFailure(call: Call<RestNierAPIResponse?>?, t: Throwable?) {
                    apiLiveData.value = APICallFailure
                }
            })
        }
    }
}