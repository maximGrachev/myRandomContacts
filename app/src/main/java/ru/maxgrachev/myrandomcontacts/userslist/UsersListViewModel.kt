package ru.maxgrachev.myrandomcontacts.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import ru.maxgrachev.myrandomcontacts.network.RandomUserApi
import retrofit2.Callback
import retrofit2.Response
import ru.maxgrachev.myrandomcontacts.network.RandomUserProperty


class UsersListViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getRandomUserProperies()
    }

    private fun getRandomUserProperies() {
        RandomUserApi.retrofitSevice.getProperties().enqueue(
            object : Callback<String> {
                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {
                    _response.value = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    _response.value = "Failure:" + t.message
                }


            }
        )
    }
}