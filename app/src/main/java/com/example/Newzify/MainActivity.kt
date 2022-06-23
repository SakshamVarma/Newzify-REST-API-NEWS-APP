package com.example.Newzify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Newzify.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BaseURL = "https://newsapi.org/v2/"

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: NewsAdapter
    lateinit var linearlayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.rvNews.setHasFixedSize(true)
        linearlayoutManager = LinearLayoutManager(this)
        linearlayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvNews.layoutManager = linearlayoutManager

        getMyData()

//        binding.rvNews.setOnClickListener{
//            val i = Intent(this,MainActivity2::class.java)
//            i.putExtra("NewsCard",)
//        }
    }

    private fun getMyData() {
        val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                BaseURL
            ).build().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<NewsClass> {
            override fun onResponse(
                call: Call<NewsClass>,
                response: Response<NewsClass>
            ) {
                val responseBody = response.body()!!
                myAdapter = NewsAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.rvNews.adapter = myAdapter
                binding.rvNews.layoutManager = linearlayoutManager

            }

            override fun onFailure(call: Call<NewsClass>, t: Throwable) {
                Log.d("Main Activity", "onFailure " + t.message)
            }
        })
    }


}