package com.kodeog.inventory.app.bobisjay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodeog.inventory.app.bobisjay.databinding.ActivityLoginVersion2Binding

class LoginVersion2 : AppCompatActivity() {
    lateinit var binding : ActivityLoginVersion2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginVersion2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener{
            //login
            var userName : String = binding.etUsernameV2.text.toString()
            var password : String = binding.etPasswordV2.text.toString()
            checkCredentials(userName,password)
        }
    }
    //                                                              boolean return it can use in testing
    private fun checkCredentials(userName:String,password:String):Boolean{
        val correctUserName: String = "admin"
        val correctPassword: String = "admin123"

        val correctUserName1: String = "cardo"
        val correctPassword1: String = "cardo123"
        if((correctUserName == userName) && (correctPassword == password)){
            // declaring Intent to go in activity home page.
            val intent = Intent(this,HomeActivity::class.java)
            // using intent to pass other data from this screen to the another screen
            intent.putExtra("sampleName",userName)
            intent.putExtra("samplePassword",password)
            // calling the intent
            startActivity(intent)
            // to kill an activity to reduce the running apps
            finish()
            Toast.makeText(applicationContext, "Welcome $correctUserName", Toast.LENGTH_SHORT).show()
            return true
        }else if((correctUserName1 == userName) && (correctPassword1 == password)) {
            // declaring Intent to go in activity home page.
            val intent = Intent(this, HomeActivity::class.java)
            // using intent to pass other data from this screen to the another screen
            intent.putExtra("sampleName", userName)
            intent.putExtra("samplePassword",password)
            // calling the intent
            startActivity(intent)
            // to kill an activity to reduce the running apps
            finish()
            Toast.makeText(applicationContext, "Welcome $userName", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(applicationContext, "Account Not Registered!", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}