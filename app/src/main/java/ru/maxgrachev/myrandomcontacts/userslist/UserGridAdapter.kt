package ru.maxgrachev.myrandomcontacts.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.maxgrachev.myrandomcontacts.databinding.UserListItemBinding
import ru.maxgrachev.myrandomcontacts.network.RandomUserProperty

class UserGridAdapter(private val onClickListener: OnClickListener):ListAdapter<RandomUserProperty.Result, UserGridAdapter.RandomUserPropertyViewHolder>(DiffCallback){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserGridAdapter.RandomUserPropertyViewHolder {
        return RandomUserPropertyViewHolder(UserListItemBinding
            .inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: UserGridAdapter.RandomUserPropertyViewHolder,
        position: Int
    ) {
        val userProperty = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(userProperty)
        }
        holder.bind(userProperty)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<RandomUserProperty.Result>(){
        override fun areItemsTheSame(
            oldItem: RandomUserProperty.Result,
            newItem: RandomUserProperty.Result
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: RandomUserProperty.Result,
            newItem: RandomUserProperty.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class RandomUserPropertyViewHolder(private var binding: UserListItemBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(userProperty: RandomUserProperty.Result){
                binding.property = userProperty
                binding.executePendingBindings()
            }
    }

    class OnClickListener(val clickListener: (userInfo: RandomUserProperty.Result)->Unit){
        fun onClick(userInfo: RandomUserProperty.Result) = clickListener(userInfo)
    }
}