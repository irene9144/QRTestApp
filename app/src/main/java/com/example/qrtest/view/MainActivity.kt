package com.example.qrtest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qrtest.adapter.CompanyAdapter
import com.example.qrtest.adapter.UserAdapter
import com.example.qrtest.api.RetrofitInstance
import com.example.qrtest.databinding.ActivityMainBinding
import com.example.qrtest.viewmodel.MainRepository
import com.example.qrtest.viewmodel.MainViewModel
import com.example.qrtest.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(MainRepository(RetrofitInstance.getApiService()))
    }
    private lateinit var adapter: CompanyAdapter
    private lateinit var userAdapter: UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

//        viewModel.companyList.observe(this, Observer {companyList ->
//            Log.e("smkwon","companyList -- > $companyList")
//            binding.recyclerView.adapter = CompanyAdapter(companyList)
//
//        })
        viewModel.userList.observe(this, Observer {userList ->
            Log.e("smkwon","companyList -- > $userList")
            binding.recyclerView.adapter = UserAdapter(userList)

        })

        binding.btnCreate.setOnClickListener {
            val intent = Intent( this, CreateQRActivity::class.java )
            startActivity(intent)
        }


        binding.btnScan.setOnClickListener {
            val intent = Intent( this, ScanQRActivity::class.java )
            startActivity(intent)
        }
    }
}