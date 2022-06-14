package com.example.meet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.meet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,Communicator{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Second(First())
    }

    private fun Second (fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer, fragment)
            .commit()
    }

    override fun dataname(etInput: String) {                        //dibikin 4 dan di .replace diganti .add di func selanjutnua
        val bundle = Bundle()
        bundle.putString("name",etInput)

        val secondFrag = Second()
        secondFrag.arguments = bundle

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer, secondFrag).commit()           //.replace disini
    }

    override fun datasquad(etInput: String) {
        val bundle = Bundle()
        bundle.putString("squad",etInput)

        val secondFrag = Second()
        secondFrag.arguments = bundle

        this.supportFragmentManager.beginTransaction()
            .add(R.id.fragmentcontainer, secondFrag).commit()
    }

    override fun dataangkatan(etInput: String) {
        val bundle = Bundle()
        bundle.putString("angkatan",etInput)


        val secondFrag = Second()
        secondFrag.arguments = bundle

        this.supportFragmentManager.beginTransaction()
            .add(R.id.fragmentcontainer, secondFrag).commit()
    }

    override fun datahobi(etInput: String) {
        val bundle = Bundle()
        bundle.putString("hobi",etInput)


        val secondFrag = Second()
        secondFrag.arguments = bundle

        this.supportFragmentManager.beginTransaction()
            .add(R.id.fragmentcontainer, secondFrag).commit()
    }

}