package ru.maxgrachev.myrandomcontacts

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.maxgrachev.myrandomcontacts.network.Result
import ru.maxgrachev.myrandomcontacts.userslist.RandomUserApiStatus
import ru.maxgrachev.myrandomcontacts.userslist.UserGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<Result>?){
    val adapter = recyclerView.adapter as UserGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("RandomUserApiStatus")
fun bindStatus(statusImageView: ImageView, status: RandomUserApiStatus){
    when(status){
        RandomUserApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        RandomUserApiStatus.ERROR->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        RandomUserApiStatus.DONE->{
            statusImageView.visibility = View.GONE
        }
    }
}