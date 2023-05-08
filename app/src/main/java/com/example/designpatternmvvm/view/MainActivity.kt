package com.example.designpatternmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designpatternmvvm.R
import com.example.designpatternmvvm.databinding.ActivityMainBinding
import com.example.designpatternmvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataUser()

    }

    fun showDataUser (){

        val viewModelNews = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModelNews.callApiUser()
        viewModelNews.liveDataUser.observe(this, {
            if (it != null){
                binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvUser.adapter = UserAdapter(it)
            }
        })
    }

}