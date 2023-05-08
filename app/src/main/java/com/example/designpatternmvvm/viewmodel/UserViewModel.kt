package com.example.designpatternmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.designpatternmvvm.model.getAllUserItem
import com.example.designpatternmvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    var liveDataUser : MutableLiveData<List<getAllUserItem>?>

    init {
        liveDataUser = MutableLiveData()
    }

    fun callApiUser() {
        ApiClient.instance.getUser()
            .enqueue(object : Callback<List<getAllUserItem>> {
                override fun onResponse(
                    call: Call<List<getAllUserItem>>,
                    response: Response<List<getAllUserItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataUser.postValue(response.body())
                    } else {
                        liveDataUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllUserItem>>, t: Throwable) {
                    liveDataUser.postValue(null)
                }
            })
    }

}