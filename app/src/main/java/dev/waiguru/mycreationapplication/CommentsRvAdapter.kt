package dev.waiguru.mycreationapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.waiguru.mycreationapplication.databinding.CommentsListBinding

class CommentsRvAdapter( var commentList: List<Comment>):
    RecyclerView.Adapter<CommentViewHolder>() { //Inherits from recyclerView.Adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListBinding

            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding) {
            holder.binding.tvPostId2.text = currentComment.postId.toString()
            holder.binding.tvID2.text = currentComment.id.toString()
            holder.binding.tvName.text = currentComment.name
            holder.binding.tvEmail2.text = currentComment.email
            holder.binding.tvCommentbody2.text = currentComment.body

        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}



class CommentViewHolder(var binding:CommentsListBinding):RecyclerView.ViewHolder(binding.root){

}