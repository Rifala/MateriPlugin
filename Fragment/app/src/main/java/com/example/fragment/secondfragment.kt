package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentSecondfragmentBinding


class secondfragment : Fragment() {

    private lateinit var binding: FragmentSecondfragmentBinding
    var getName: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // disamakan juga dengan activity
        binding = FragmentSecondfragmentBinding.inflate(layoutInflater)

        //data dari dataname disini
        getName = arguments?.getString("name")       //key harus sama seperti key di mainActivity.kt
        binding.tvName.text = getName


        return binding.root
    }


}