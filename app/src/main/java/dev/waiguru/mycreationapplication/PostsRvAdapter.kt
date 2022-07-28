package dev.waiguru.mycreationapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.waiguru.mycreationapplication.databinding.PostsListsBinding

class PostsRvAdapter(var context: Context, var postList: List<Posts>):
    RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding=PostsListsBinding

            .inflate(LayoutInflater.from(context),parent,false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentPost= postList.get(position)
        with(holder.binding){
            tvUserId.text=currentPost.userId.toString()
            tvId.text=currentPost.id.toString()
            tvTitle.text=currentPost.title
            tvBody.text=currentPost.body


        }
    }

    override fun getItemCount(): Int {
        return postList.size

    }

}





class RetrofitViewHolder(var binding:PostsListsBinding):RecyclerView.ViewHolder(binding.root){

}