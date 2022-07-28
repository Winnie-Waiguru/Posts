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
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }

    fun getPosts(){
        val retrofit=APIClient.buildApiClient((ApiInterface::class.java))
        val request= retrofit.getPosts()

        request.enqueue(object: Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    val post= response.body()!!  //Pass post to the main activity to display the posts
                    Toast.makeText(baseContext, "Fetched ${post!!.size} post",
                    Toast.LENGTH_LONG).show()
                    var postsAdapter= PostsRvAdapter(baseContext, post)
                    binding.rvPosts.layoutManager = LinearLayoutManager(baseContext)
                    binding.rvPosts.adapter = postsAdapter

                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }

        })


    }
}