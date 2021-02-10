package ru.maxgrachev.myrandomcontacts.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.maxgrachev.myrandomcontacts.databinding.UserListItemBinding
import ru.maxgrachev.myrandomcontacts.network.Result
class UserGridAdapter(private val onClickListener: OnClickListener):ListAdapter<Result, UserGridAdapter.RandomUserPropertyViewHolder>(DiffCallback){
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

    companion object DiffCallback: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class RandomUserPropertyViewHolder(private var binding: UserListItemBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(userProperty: Result){
                binding.property = userProperty
                binding.executePendingBindings()
            }
    }

    class OnClickListener(val clickListener: (userInfo: Result)->Unit){
        fun onClick(userInfo: Result) = clickListener(userInfo)
    }
}