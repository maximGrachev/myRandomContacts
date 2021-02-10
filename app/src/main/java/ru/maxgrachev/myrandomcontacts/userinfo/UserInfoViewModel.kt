package ru.maxgrachev.myrandomcontacts.userinfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.maxgrachev.myrandomcontacts.network.Result

class UserInfoViewModel(userInfo: Result,
app: Application): AndroidViewModel(app) {
    private val _selectedUser = MutableLiveData<Result>()
    val selectedUser: LiveData<Result>
        get()=_selectedUser

    init{
        _selectedUser.value = userInfo
    }
}