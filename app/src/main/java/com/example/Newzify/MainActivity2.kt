package com.example.Newzify

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.Newzify.databinding.ActivityMain2Binding
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.newsTitle.text = intent.getStringExtra("title")
        binding.newsDesc.text = intent.getStringExtra("desc")
        Glide.with(baseContext).load(intent.getStringExtra("urlToImage"))
            .placeholder(R.drawable.not_available).error(R.drawable.not_available)
            .into(binding.newsImage)

        binding.visit.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(intent.getStringExtra("url"))
            startActivity(i)
        }

        binding.share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, intent.getStringExtra("url"))
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }
}
