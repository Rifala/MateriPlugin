package com.example.week2room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2room.Room.Entity
import com.example.week2room.Room.SetupRoomDB
import com.example.week2room.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    val db by lazy { SetupRoomDB(this) }
    private var getId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        updataData()

    }

    private fun getData(){
        getId = intent.getIntExtra("id",0)
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.dao().ReadDataById(getId)[0]
            binding.ETnama.setText(data.nama)
            binding.ETProdi.setText(data.prodi)
        }
    }

    private fun  updataData(){
        binding.BtnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.dao().updateData(
                 Entity(getId,binding.ETnama.text.toString(), binding.ETProdi.text.toString())
                )
            }
            startActivity(Intent(this, MainActivity::class.java).also{
                finish()
            })
         }
    }
}