package com.example.week2room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week2room.Room.Entity
import com.example.week2room.Room.SetupRoomDB
import com.example.week2room.databinding.ActivityCreateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateActivity : AppCompatActivity() {
    private val db by lazy{SetupRoomDB(this)}
    private lateinit var binding : ActivityCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CreatedData()
    }

    private fun CreatedData(){
        binding.BtnSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.dao().CreateData(Entity(0,binding.ETnama.text.toString(),binding.ETProdi.text.toString()))
                startActivity(Intent(this@CreateActivity,MainActivity::class.java).also{
                    finish()
                })

            }

        }
    }
}