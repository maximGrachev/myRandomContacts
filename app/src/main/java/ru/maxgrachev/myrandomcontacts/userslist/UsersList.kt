package ru.maxgrachev.myrandomcontacts.userslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.maxgrachev.myrandomcontacts.databinding.FragmentUsersListBinding

class UsersList : Fragment() {

    private val viewModel:UsersListViewModel by lazy{
        ViewModelProvider(this).get(UsersListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentUsersListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel.response.observe(viewLifecycleOwner, Observer{
            binding.responseText.text = it
        })

        return binding.root
    }
}
