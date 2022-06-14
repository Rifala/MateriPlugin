package com.example.week2room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2room.Room.SetupRoomDB
import com.example.week2room.databinding.ActivityDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private val db by lazy{SetupRoomDB(this)}
    private lateinit var binding : ActivityDetailBinding
    private var get_Id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DetailData()
    }

    private fun DetailData(){
        get_Id = intent.getIntExtra("id",0)
        CoroutineScope(Dispatchers.IO).launch {
            val getAllData = db.dao().ReadDataById(get_Id)[0]
            binding.ETnama.setText(getAllData.nama)
            binding.ETProdi.setText(getAllData.prodi)
        }

    }
}