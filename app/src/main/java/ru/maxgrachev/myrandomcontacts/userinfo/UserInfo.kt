package ru.maxgrachev.myrandomcontacts.userinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.maxgrachev.myrandomcontacts.databinding.FragmentUserInfoBinding

class UserInfo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserInfoBinding.inflate(inflater)
        return binding.root
    }
}

