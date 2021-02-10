package ru.maxgrachev.myrandomcontacts.userinfo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maxgrachev.myrandomcontacts.network.Result

class UserInfoViewModelFactory(
    private val userInfo: Result,
    private val application: Application):ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserInfoViewModel::class.java)) {
            return UserInfoViewModel(userInfo, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}