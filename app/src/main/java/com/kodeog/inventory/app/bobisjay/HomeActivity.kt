package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodeog.inventory.app.bobisjay.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //calling the other data in another activity
        var name : String? = intent.getStringExtra("sampleName")
        binding.textWelcome.text = "Welcome $name"
        var password : String? = intent.getStringExtra("samplePassword")
        binding.textsample.text = "Password is $password"

    }
}