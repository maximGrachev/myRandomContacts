package ru.maxgrachev.myrandomcontacts.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.maxgrachev.myrandomcontacts.network.RandomUserApi
import ru.maxgrachev.myrandomcontacts.network.RandomUserProperty


class UsersListViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _property = MutableLiveData<RandomUserProperty.Result>()
    val property: LiveData<RandomUserProperty.Result>
        get() = _property

    init {
        getRandomUserProperies()
    }

    fun getRandomUserProperies() {
        viewModelScope.launch {
            try {
                val listResult: RandomUserProperty = RandomUserApi.retrofitSevice.getProperties()
                _response.value = "Success: ${listResult.results.size} users' properties retrieved"
                if(listResult.results.isNotEmpty()){
                    _property.value = listResult.results[0]
                }
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}