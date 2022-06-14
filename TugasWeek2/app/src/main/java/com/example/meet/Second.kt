package com.example.meet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meet.databinding.FragmentSecondBinding

class Second : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    var getName: String? = ""
    var getSquad: String? = ""
    var getAngkatan: String? = ""
    var getHobi: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater)


        getName = arguments?.getString("name")       //key harus sama seperti key di mainActivity.kt
        binding.tvName.text = getName

        getSquad = arguments?.getString("squad")
        binding.tvSquad.text = getSquad

        getAngkatan = arguments?.getString("angkatan")
        binding.tvAngkatan.text = getAngkatan

        getHobi = arguments?.getString("hobi")
        binding.tvHobi.text = getHobi

        return binding.root
    }

}