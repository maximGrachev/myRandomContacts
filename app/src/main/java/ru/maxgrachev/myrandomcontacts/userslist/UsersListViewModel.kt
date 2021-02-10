package ru.maxgrachev.myrandomcontacts.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.maxgrachev.myrandomcontacts.network.RandomUserApi
import ru.maxgrachev.myrandomcontacts.network.Result

enum class RandomUserApiStatus { LOADING, ERROR, DONE }

class UsersListViewModel : ViewModel() {

    private val _status = MutableLiveData<RandomUserApiStatus>()
    val status: LiveData<RandomUserApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<Result>>()
    val properties: LiveData<List<Result>>
        get() = _properties

    private val _navigateToSelectedUser = MutableLiveData<Result>()
    val navigateToSelectedUser: LiveData<Result>
        get() = _navigateToSelectedUser

    init {
        getRandomUserProperies()
    }

    fun getRandomUserProperies() {
        viewModelScope.launch {
            _status.value = RandomUserApiStatus.LOADING
            try {
                _properties.value = RandomUserApi.retrofitSevice.getProperties().results
                _status.value = RandomUserApiStatus.DONE
            } catch (e: Exception) {
                _status.value = RandomUserApiStatus.ERROR
            }
        }
    }

    fun displayUserInfo(userInfo: Result){
        _navigateToSelectedUser.value = userInfo
    }

    fun displayUserInfoComplete(){
        _navigateToSelectedUser.value = null
    }
}