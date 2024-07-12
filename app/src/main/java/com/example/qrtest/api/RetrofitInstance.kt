package com.example.qrtest.api

import com.example.qrtest.util.Constant
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var instance: Retrofit? = null

/* Coroutine 사용안할때

    fun getApiService():ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
    private fun getRetrofit(): Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }
*/
fun getApiService():ApiService {
    return getRetrofit().create(ApiService::class.java)
}
    private fun getRetrofit(): Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

}