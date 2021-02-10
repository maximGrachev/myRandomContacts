package ru.maxgrachev.myrandomcontacts.userinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.maxgrachev.myrandomcontacts.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        val binding = FragmentUserInfoBinding.inflate(inflater)
        val userInfo = UserInfoFragmentArgs.fromBundle(arguments!!).selectedUserInfo
        val application = requireNotNull(activity).application
        val viewModelFactory = UserInfoViewModelFactory(userInfo, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(UserInfoViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }
}

