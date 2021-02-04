package ru.maxgrachev.myrandomcontacts.userinfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.maxgrachev.myrandomcontacts.network.RandomUserProperty

class UserInfoViewModel(userInfo: RandomUserProperty.Result,
app: Application): AndroidViewModel(app) {
    private val _selectedUser = MutableLiveData<RandomUserProperty.Result>()
    val selectedUser: LiveData<RandomUserProperty.Result>
        get()=_selectedUser

    init{
        _selectedUser.value = userInfo
    }
}