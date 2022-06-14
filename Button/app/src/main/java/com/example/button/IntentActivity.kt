package com.example.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.button.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUsername.text = intent.getStringExtra("Username")
        binding.tvUsername2.text = intent.getStringExtra("Password")
    }
}