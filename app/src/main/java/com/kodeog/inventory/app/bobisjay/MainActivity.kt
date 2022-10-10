package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var password: TextView
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
        login = findViewById(R.id.btSignIn)

        login.setOnClickListener {
            if (username.getText().equals("admin")) {
                if (password.getText().equals("admin")) {
                    Toast.makeText(this, "Log in Successfull", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "INVALID!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
