package com.example.button

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.button.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Intent explicit, pindah activity lain
        binding.binSave.setOnClickListener {
            startActivity(Intent(this,IntentActivity::class.java).apply {
                putExtra("Username", binding.etUsername.text.toString())
                putExtra("Password", binding.etPassword.text.toString())
            })
        }

        //intent implicit, pindah ke aplikasi lain
        binding.btnIg.setOnClickListener {
            val ig = Intent(Intent.ACTION_VIEW)
            ig.setData(Uri.parse("http://instagram.com/a"))
            startActivity(ig)
        }



    }
}