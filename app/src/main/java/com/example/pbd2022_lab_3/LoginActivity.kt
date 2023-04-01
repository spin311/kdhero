package com.example.pbd2022_lab_3

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        button =  findViewById(R.id.lgn_btn)

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
    fun login(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        Log.d(TAG, "login")
        startActivity(intent)
    }
    fun register(view: View?) {
        val intent = Intent(this, RegistrationActivity::class.java)
        Log.d(TAG, "register")
        startActivity(intent)
    }

}