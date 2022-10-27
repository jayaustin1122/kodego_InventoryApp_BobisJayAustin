package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.kodeog.inventory.app.bobisjay.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    //Binding the xml to kt.
    private lateinit var binding : ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //calling all fragments
        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()
        val fragmentThree = FragmentThree()

            // to call the initial fragment display in screen
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentMain.id,fragmentOne)
            commit()
        }
        //accessing button 1
        binding.button.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id,fragmentOne)
                // creating a backstack
                addToBackStack(null)
                commit()
            }
        }
        //accessing button 2
        binding.button2.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id,fragmentTwo)
                // creating a backstack
                addToBackStack(null)
                commit()
            }
        }
        //accessing button 3
        binding.button3.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id,fragmentThree)
                // creating a backstack
                addToBackStack(null)
                commit()
            }
        }
    }
}