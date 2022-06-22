package com.example.apitest

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apitest.databinding.ActivityMainBinding
import com.example.apitest.databinding.ActivityCardLayoutBinding
import android.content.Context as Context

class NewsAdapter(val context: Context, val items: NewsClass): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ActivityCardLayoutBinding) : RecyclerView.ViewHolder(binding.root){
    val image: View? = binding.newsImage
    val title: View? = binding.newsTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder)
        {
            with(items){
                binding.newsTitle.text = articles[position].title
            }
            Glide.with(itemView.context).load(items.articles[position].urlToImage).placeholder(R.drawable.not_available)
                .error(R.drawable.not_available).into(binding.newsImage)

        }
        holder.binding.cardView.setOnClickListener {
            val i = Intent(holder.itemView.context,MainActivity2::class.java)
            i.putExtra("title",items.articles[position].title)
            i.putExtra("content",items.articles[position].content)
            i.putExtra("publishedAt",items.articles[position].publishedAt)
            i.putExtra("desc",items.articles[position].description)
            i.putExtra("urlToImage",items.articles[position].urlToImage)
            i.putExtra("url",items.articles[position].url)
            holder.itemView.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return items.articles.size
    }
}