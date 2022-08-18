package dev.waiguru.mycreationapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.waiguru.mycreationapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }

    fun getPosts() {
        val apiClient = APIClient.buildApiClient((ApiInterface::class.java))
        val request = apiClient.getPosts()
//Enqueue remove the long running tasks and replaces it in another seperates thread to make a request call, responses are received on this thread that's why callbacks are necessary
        request.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    if (posts != null) {
                        displayPosts(posts)
                    }


                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

        fun displayPosts(postList: List<Posts>) {
            binding.rvPosts.layoutManager = LinearLayoutManager(this)
            val postsAdapter = PostsRvAdapter(postList)
            binding.rvPosts.adapter = postsAdapter
        }
    }




