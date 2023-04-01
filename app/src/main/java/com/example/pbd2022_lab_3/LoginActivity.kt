package com.example.pbd2022_lab_3

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var password: TextView
    private lateinit var button: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById<TextView>(R.id.username)
        password = findViewById<TextView>(R.id.password)
        button =  findViewById(R.id.loginbtn)

        // admin and admin
        button.setOnClickListener {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                // correct
                Toast.makeText(this, "LOGIN SUCCESFUL", Toast.LENGTH_SHORT).show()
            } else {
                // incorrect
                Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show()

            }
        }
    }
}