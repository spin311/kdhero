package com.example.pbd2022_lab_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), HomeFragment.MyFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = this.getSharedPreferences("userId", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("userId", "1")
        editor.apply()

        replaceFragment(HomeFragment())
    }

    override fun onMyVariableSet(myVariable: String){
        val coinCount: TextView = findViewById(R.id.username)
        coinCount.text = myVariable
        Log.d("MainActivity", "onMyVariableSet: $myVariable")

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.activityMain, fragment)
        fragmentTransaction.commit()
    }
}