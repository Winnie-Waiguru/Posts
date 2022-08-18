package dev.waiguru.mycreationapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.waiguru.mycreationapplication.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPosts()
    }

    fun obtainPostId(){
        postId= intent.extras?.getInt("POST_ID")?: 0
    }

    fun fetchPosts(){
        var apiClient = APIClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)

        request.enqueue(object: Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                var  post =response.body()
                if (post!= null){
                    binding.tvPostTitle.text=post.title
                    binding.tvPostBody.text=post.body
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {

            }

        })
    }
}

//Abstraction: Hiding the inner working of an app from a user