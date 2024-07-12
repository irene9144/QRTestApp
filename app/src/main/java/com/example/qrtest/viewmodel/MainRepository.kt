package com.example.qrtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.qrtest.api.ApiService
import com.example.qrtest.model.ApiResponseFromJson
import com.example.qrtest.model.ApiUserResponseFromJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val apiService: ApiService) {
//    suspend fun getCompanyList(): ApiResponse {
//        return apiService.getCompanyList()
//    }
     /*fun getCompanyList(): LiveData<List<Company>> {
         val data = MutableLiveData<List<Company>>()
        apiService.getCompanyList().enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                data.value = response.body()!!.dataList
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.stackTrace
            }
        })
        return data
     }*/

    suspend fun getCompanyList(): Response<ApiResponseFromJson>
    {

        return apiService.getCompanyList()
    }
    suspend fun getUserList(): Response<ApiUserResponseFromJson>
    {

        return apiService.getUserList(1)
    }

}