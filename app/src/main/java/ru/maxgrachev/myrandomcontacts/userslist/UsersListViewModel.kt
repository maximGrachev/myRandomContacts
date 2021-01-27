package ru.maxgrachev.myrandomcontacts.userslist

import android.util.Log
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

    fun getRandomUserProperies() {
        RandomUserApi.retrofitSevice.getProperties().enqueue(
            object : Callback<RandomUserProperty> {
                override fun onResponse(
                    call: Call<RandomUserProperty>,
                    response: Response<RandomUserProperty>
                ) {
                    _response.value = "Success: ${response.body()?.results} users' properties retrieved"
//                    Log.i("onResponce", "$a");
                }

                override fun onFailure(call: Call<RandomUserProperty>, t: Throwable) {
                    _response.value = "Failure:" + t.message
                    Log.i("onResponce", "Failure");
                }


            }
        )
    }
}