package com.example.batch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.batch3.Model.DataName
import com.example.batch3.ViewModel.viewmodel
import com.example.batch3.databinding.ActivityMvvmBinding

class MVVM : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmBinding
    private lateinit var viewModel: viewmodel
//    private var firstName = ""
//    private var lastName = ""

    companion object{
        const val FN = "firstname"
        const val LN = "lastname"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(viewmodel::class.java)
        viewModel.data.observe(this,{
            binding.tvResult.text = "hay . . . namaku ${it.firstname} ${it.lastname}"
        })

        binding.btnSimpan.setOnClickListener {
            viewModel.setData(DataName(
                binding.etFirstNam.text.toString(),
                binding.etLastName.text.toString()
            ))
        }

        //yg di komen kalo ngga pake mvvm

//        if(savedInstanceState != null){
//            firstName = savedInstanceState.getString(FN)!!
//            lastName = savedInstanceState.getString(LN)!!
//
//            binding.tvResult.text = "hay . . . namaku $firstName $lastName"
//        }
//
//        binding.btnSimpan.setOnClickListener {
//            firstName = binding.etFirstNam.text.toString()
//            lastName = binding.etLastName.text.toString()
//
//            binding.tvResult.text = "hay . . . namaku $firstName $lastName"
//        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putString(FN,firstName)
//        outState.putString(LN,lastName)
//        super.onSaveInstanceState(outState)
//    }


}