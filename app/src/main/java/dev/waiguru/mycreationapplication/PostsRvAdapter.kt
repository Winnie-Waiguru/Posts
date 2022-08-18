package dev.waiguru.mycreationapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.waiguru.mycreationapplication.databinding.PostsListsBinding

class PostsRvAdapter( var postList: List<Posts>):
    RecyclerView.Adapter<RetrofitViewHolder>(){ //Inherits from recyclerView.Adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding=PostsListsBinding

            .inflate(LayoutInflater.from(parent.context),parent, false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentPost = postList.get(position)
        with(holder.binding) {
            holder.binding.tvUserId.text = currentPost.userId.toString()
            holder.binding.tvId.text = currentPost.id.toString()
            holder.binding.tvTitle.text = currentPost.title
            holder.binding.tvBody.text = currentPost.body
            val context = holder.itemView.context
            holder.binding.cvPosts.setOnClickListener {
                val intent = Intent(context, CommentActivity::class.java)
                intent.putExtra("POST_ID", currentPost.id)
                context.startActivity(intent)
            }


        }
    }

    override fun getItemCount(): Int {
        return  postList.size
    }
}





class RetrofitViewHolder(var binding:PostsListsBinding):RecyclerView.ViewHolder(binding.root){

}