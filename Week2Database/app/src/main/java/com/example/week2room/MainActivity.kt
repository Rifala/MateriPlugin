package com.example.week2room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week2room.Adapter.MainAdapter
import com.example.week2room.Room.Entity
import com.example.week2room.Room.SetupRoomDB
import com.example.week2room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val db by lazy {SetupRoomDB(this)}
    private lateinit var binding : ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private  var listdata : MutableList<Entity> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moveActivity()
        ReadData()
        showRecycler()
    }

    private fun moveActivity(){
       binding.buttonCreate.setOnClickListener {
           startActivity(Intent(this,CreateActivity::class.java))
       }
    }


    private fun ReadData(){
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.dao().ReadData()
            Log.d("RoomDB","$data")
            listdata.addAll(data)
            withContext(Dispatchers.Main){
                mainAdapter.reloadRecycler(data)
            }
        }
    }

    private fun showRecycler(){
        mainAdapter = MainAdapter(listdata,object : MainAdapter.onClick{
            override fun TextClick(entity: Entity) {
                startActivity(Intent(this@MainActivity,DetailActivity::class.java).also{
                    it.putExtra("id",entity.id)
                })
            }

            override fun onUpdate(entity: Entity) {
                startActivity(Intent(this@MainActivity, UpdateActivity::class.java).also{
                    it.putExtra("id",entity.id)
                })
            }

            override fun onDelete(entity: Entity) {
                CoroutineScope(Dispatchers.IO).launch {
                    db.dao().deleteData(entity)
                    ReadData()
                }
            }

        })
        binding.Recycler.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }
}