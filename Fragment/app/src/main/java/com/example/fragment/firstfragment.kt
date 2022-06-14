package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentFirstfragmentBinding

class firstfragment : Fragment() {

    private lateinit var binding: FragmentFirstfragmentBinding
    private lateinit var com: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //disamakan dengan activity
        binding = FragmentFirstfragmentBinding.inflate(layoutInflater)
        com = activity as Communicator

        //data dari edittext akan dikirim ke dataname pada mainactivity.kt
        binding.btnSecFrag.setOnClickListener {
            com.dataname(binding.etName.text.toString())
        }


        return binding.root
    }

}