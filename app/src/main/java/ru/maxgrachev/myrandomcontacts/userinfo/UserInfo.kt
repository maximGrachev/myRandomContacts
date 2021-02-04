package ru.maxgrachev.myrandomcontacts.userinfo

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.maxgrachev.myrandomcontacts.MainActivity
import ru.maxgrachev.myrandomcontacts.databinding.FragmentUserInfoBinding

class UserInfo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        val binding = FragmentUserInfoBinding.inflate(inflater)
        val userInfo = UserInfoArgs.fromBundle(arguments!!).selectedUserInfo
        val application = requireNotNull(activity).application
        val viewModelFactory = UserInfoViewModelFactory(userInfo, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(UserInfoViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }
}

