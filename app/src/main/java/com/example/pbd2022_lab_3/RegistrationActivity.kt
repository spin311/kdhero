package com.example.pbd2022_lab_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private var username: String = ""
    private var password: String = ""
    private var passwordRepeat: String = ""
    private var email: String = ""
    private var age: String = ""
    private var gender:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        username = findViewById<EditText>(R.id.username).text.toString()
        password = findViewById<EditText>(R.id.password).text.toString()
        passwordRepeat = findViewById<EditText>(R.id.passwordRepeat).text.toString()
        email = findViewById<EditText>(R.id.email).text.toString()
        age = findViewById<EditText>(R.id.age).text.toString()
        gender = ""
        val genderSpinner: Spinner = findViewById(R.id.genderSpinner)
        val genders = arrayOf("Izberi spol", "Moški", "Ženski")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
        genderSpinner.adapter = adapter
        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                gender = genders[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // do nothing
            }
        }
    }
    fun login(view: View?) {
            var intAge:Int = 0
            if (age!!.isNotEmpty()) {
                intAge = age!!.toInt()

            }
        if (username.isEmpty()) {
            Toast.makeText(this, "username", Toast.LENGTH_SHORT).show()
        } else if (password.isEmpty()) {
            Toast.makeText(this, "password", Toast.LENGTH_SHORT).show()
        }  else if (passwordRepeat.isEmpty()) {
             Toast.makeText(this, "rep", Toast.LENGTH_SHORT).show()
        }  else if (email.isEmpty()) {
            Toast.makeText(this, "email", Toast.LENGTH_SHORT).show()
        }  else if (intAge == null) {
            Toast.makeText(this, "username", Toast.LENGTH_SHORT).show()

        }

        if (username!!.isEmpty() || password!!.isEmpty() || passwordRepeat!!.isEmpty() || email!!.isEmpty() || intAge == null || intAge <= 0 || gender.equals("Izberi spol") || !password.equals(passwordRepeat)) {
            // at least one of the variables is empty / not right
            Toast.makeText(this, "Napaka pri registraciji", Toast.LENGTH_SHORT).show()
        } else {
            // all variables are not empty, and age is a valid integer
            var genderDb = ""
            if (gender.equals("Moški")) {
                genderDb = "m"
            } else {
                genderDb = "f"
            }
            var regUser = Person(username!!, password!!, intAge, email!!, genderDb, 0, ArrayList<Activity>(), ArrayList<Activity>(), ArrayList<Activity>(), ArrayList<Int>())
            // TO DO save user to database
            Toast.makeText(this, "Registracija uspešna", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}