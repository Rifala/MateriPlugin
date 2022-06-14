package com.example.mvvmwithroom.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithroom.R
import com.example.mvvmwithroom.ViewModel.UserViewModel
import com.example.mvvmwithroom.databinding.ActivityCreateBinding
import java.security.Provider

class Create : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding
    lateinit var userViewModel: UserViewModel
    lateinit var nama: String
    lateinit var prodi: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        btnSave()
    }

    private fun btnSave(){
        binding.BtnSave.setOnClickListener {
            nama = binding.ETnama.text.toString()
            prodi = binding.ETProdi.text.toString()
            if (nama.isEmpty()){
                binding.ETnama.error = "Please fill the name"
            }else if (prodi.isEmpty()){
                binding.ETProdi.error = "Please fill the prodi"
            }else{
                userViewModel.insert(this,nama,prodi)
                Toast.makeText(applicationContext, "Create data successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java).also { finish() })
            }
        }
    }


}