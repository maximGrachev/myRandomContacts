package ru.maxgrachev.myrandomcontacts.userslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.maxgrachev.myrandomcontacts.databinding.FragmentUsersListBinding
import ru.maxgrachev.myrandomcontacts.databinding.UserListItemBinding

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
//        val binding = UserListItemBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.usersGrid.adapter = UserGridAdapter(UserGridAdapter.OnClickListener{
            viewModel.displayUserInfo(it)
        })
        viewModel.navigateToSelectedUser.observe(viewLifecycleOwner, Observer {
            if(null!=it){
                this.findNavController().navigate(
                    UsersListDirections.actionUsersList5ToUserInfo(it)
                )
                viewModel.displayUserInfoComplete()
            }
        })

        return binding.root
    }
}
