package com.aweirdtrashcan.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aweirdtrashcan.passwordgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var password : String? = null
    private lateinit var binding : ActivityMainBinding
    private val characters = arrayOf(1,2,3,4,5,6,7,8,9,"a","b","c","d","e","f","g","h","i","j","k","[","{","_","+")
    private var amount : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerate.setOnClickListener {
            amount = (binding.etAmount.text.toString().toInt() - 1)
            generate()
        }

    }

    private fun generate(){
        amount?.let {
            password = characters.random().toString()
            for (i in 0..amount!!){
                password += characters.random().toString()
            }
            passwordToTv(password!!)
        }
    }

    private fun passwordToTv(password : String){
        binding.tvPassAmount.text = password
    }

}