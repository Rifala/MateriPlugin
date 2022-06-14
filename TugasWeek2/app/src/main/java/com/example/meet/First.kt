package com.example.meet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meet.databinding.FragmentFirstBinding


class First : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var com: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater)
        com = activity as Communicator


        binding.SaveBtn.setOnClickListener {
            com.dataname(binding.Name.text.toString())
            com.datasquad(binding.Squad.text.toString())
            com.dataangkatan(binding.Angkatan.text.toString())
            com.datahobi(binding.Hobi.text.toString())
        }
        


        return binding.root
    }
}