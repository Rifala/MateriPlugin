package com.example.mvvmwithroom.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmwithroom.Adapter.MainAdapter
import com.example.mvvmwithroom.ViewModel.UserViewModel
import com.example.mvvmwithroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: UserViewModel
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdapter = MainAdapter(mutableListOf())
        binding.Recycler.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.show(this)?.observe(this, Observer {
            mainAdapter.setData(it)
        })

        binding.buttonCreate.setOnClickListener {
            startActivity(Intent(this,Create::class.java))
        }

    }
}