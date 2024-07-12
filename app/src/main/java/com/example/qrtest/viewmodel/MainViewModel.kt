package com.example.qrtest.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.qrtest.model.Company
import com.example.qrtest.model.User
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: MainRepository):ViewModel (){
    /* coroutine 아닐때

    private val companyList = repository.getCompanyList()

    fun getCompanyData():LiveData<List<Company>> {
        return companyList
    }*/

    val companyList = liveData(Dispatchers.IO){
        try {
            val response = repository.getCompanyList()
            Log.e("smkwon","$response")
            val companyList = response.body()!!.data

            emit(companyList)

        }catch (e: Exception) {
            emit(emptyList<Company>())
        }
    }

    val userList = liveData(Dispatchers.IO){
        try {
            val response = repository.getUserList()
            Log.e("smkwon","$response")
            val userList = response.body()!!.data

            emit(userList)

        }catch (e: Exception) {
            emit(emptyList<User>())
        }
    }
}