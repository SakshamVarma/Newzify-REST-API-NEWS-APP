package com.example.apitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apitest.databinding.ActivityCardLayoutBinding

class CardLayout : AppCompatActivity() {
    private lateinit var binding: ActivityCardLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCardLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}