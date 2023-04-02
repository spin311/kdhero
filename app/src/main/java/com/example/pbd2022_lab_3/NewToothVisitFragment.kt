package com.example.pbd2022_lab_3

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.io.File


class NewToothVisitFragment : Fragment() {
    var imageView: ImageView? = null
    var setDate: TextView? = null
    var bitmap: Bitmap? = null
    var sharedPreferences:SharedPreferences? = null
    var sharedPreferencesJson:SharedPreferences? = null
    var don:ArrayList<com.example.pbd2022_lab_3.Activity>? = null
    var user:String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_new_tooth_visit, container, false)
        setDate = view.findViewById(R.id.donation_date)
        imageView = view.findViewById(R.id.donation_image) as ImageView
        var saveButton = view.findViewById<Button>(R.id.button_save)

        imageView?.setOnClickListener {
            addImage()
        }
        setDate!!.text = getTodaysDate()
        setDateLabel(view)
        //key, value
        sharedPreferences = view?.context?.getSharedPreferences("userId", Context.MODE_PRIVATE)
        saveButton.setOnClickListener {
            var donationData: com.example.pbd2022_lab_3.Activity? = null
            if(bitmap != null) {
                donationData = Activity(setDate?.text.toString(), compressImage().toString())
            } else {
                donationData = Activity(setDate?.text.toString(), "")
            }

            user = sharedPreferences?.getString("userId", "0")
            sharedPreferencesJson = view?.context?.getSharedPreferences("all", Context.MODE_PRIVATE)
            // dobim vse podatke
            val dataFile = returnDataFile("all", sharedPreferencesJson!!)
            val editor = sharedPreferencesJson?.edit()


            if(duplicateDate(setDate?.text.toString())) {
                Toast.makeText(view.context, "You already have a visit on this date", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            when(user) {
                "1" -> dataFile?.dent1?.add(donationData)
                "2" -> dataFile?.dent2?.add(donationData)
                "3" -> dataFile?.dent3?.add(donationData)
            }

            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.activityMain, ToothFragment())?.commit()

        }
        return view
    }

    // add calendar view

    // set date as content on textView
    private fun setDateLabel(view: View) {

        val calendar: Calendar = Calendar.getInstance()
        var format = ""
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            format = setLabel(calendar)
            setDate?.text = format
        }


        setDate?.setOnClickListener {
            Log.d("here","hello")
            DatePickerDialog(view.context, datePicker, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        Log.d("formatDate", format)
    }

    // checks if you try to save to do list with the same date as one that is already saved
    private fun duplicateDate(date: String) : Boolean {

        // pogledas v userjevem shared preferencu

        don?.let {
            for(i in it) {
                if(i.date.equals(date)) {
                    return true
                }
            }
        }
        return false

    }

    // open camera when user wants to change the image
    fun addImage() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivityForResult(intent, 101)
    }

    private fun compressImage(): String? {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        val img =
            android.util.Base64.encodeToString(byteArray, android.util.Base64.DEFAULT)
        byteArrayOutputStream.flush()
        byteArrayOutputStream.close()

        return img
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101) {
            if (resultCode == Activity.RESULT_OK) {
                // set image as imageView source
                bitmap = data?.extras?.get("data") as Bitmap
                imageView?.setImageBitmap(bitmap)

            }
        }
    }


}