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

    private val _properties = MutableLiveData<List<RandomUserProperty.Result>>()
    val properties: LiveData<List<RandomUserProperty.Result>>
        get() = _properties

    init {
        getRandomUserProperies()
    }

    fun getRandomUserProperies() {
        viewModelScope.launch {
            try {
                _properties.value = RandomUserApi.retrofitSevice.getProperties().results
                _response.value = "Success: ${_properties.value!!.size} Users' properties retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}