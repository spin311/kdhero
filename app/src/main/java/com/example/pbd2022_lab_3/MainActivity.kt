package com.example.pbd2022_lab_3

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.FirebaseDatabase
import java.io.FileInputStream


class MainActivity : AppCompatActivity(),  HomeFragment.MyFragmentListener {

    var sharedPreferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("current_user", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        //TODO("prek logina oziroma registra moramo pridobiti username")
        editor?.putString("current_user", "jan33")?.apply()

        replaceFragment(HomeFragment())

    }

    override fun onMyVariableSet(myVariable: String){
        val coinCount: TextView = findViewById<TextView>(R.id.username)
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