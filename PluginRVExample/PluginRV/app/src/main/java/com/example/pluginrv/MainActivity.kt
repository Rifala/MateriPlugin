package com.example.pluginrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pluginrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapterList:AdapterView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // data untuk mengisi adapter
        val listAndroid:List<DataView> = listOf(
        DataView(1, R.drawable.download, "Android 5", "Android versi 5"),
        DataView(1, R.drawable.download, "Android 6", "Android versi 6"),
        DataView(1, R.drawable.download, "Android 7", "Android versi 7"),
        DataView(1, R.drawable.download, "Android 8", "Android versi 8"),
        DataView(1, R.drawable.download, "Android 9", "Android versi 9"),
        DataView(1, R.drawable.download, "Android 10", "Android versi 10"),
            DataView(1, R.drawable.download, "Android 11", "Android versi 111"),
            DataView(1, R.drawable.download, "Android 12", "Android versi 12"),
        )

        // adapter di isi data di atas
        adapterList = AdapterView(listAndroid)
        // set Recyclerview dalam bentuk list
        binding.rv.layoutManager = LinearLayoutManager(this)
        // hubungkan adapter
        binding.rv.adapter = adapterList
    }
}