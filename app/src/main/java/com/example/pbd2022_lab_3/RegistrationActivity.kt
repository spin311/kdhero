package com.example.pbd2022_lab_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val genderSpinner: Spinner = findViewById(R.id.genderSpinner)
        val genders = arrayOf("Izberi spol", "Moški", "Ženski")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
        genderSpinner.adapter = adapter
        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                if (position == 0) {
                    // do nothing
                } else {
                    // do somethin
                    Log.d("TAG", genders[position])
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // do nothing
            }
        }
    }
    fun login(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}