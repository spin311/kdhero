package com.example.pbd2022_lab_3

import android.content.Context
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson

class ToothRecyclerAdapter(context: Context): RecyclerView.Adapter<ToothRecyclerAdapter.CardViewHolder>(){

    private var sharedPreferences:SharedPreferences? = context.getSharedPreferences("current_user", Context.MODE_PRIVATE)

    val userName = sharedPreferences?.getString("current_user", "0")

    val databaseRef = FirebaseDatabase.getInstance("https://zdravko-7bddd-default-rtdb.europe-west1.firebasedatabase.app").reference
    val userObject = databaseRef.child("users").child(userName.toString())
    var user:Person? = null

    inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var imageView:ImageView? = null
        var date: TextView? = null
        init {

            imageView = itemView?.findViewById(R.id.item_image)
            date = itemView?.findViewById(R.id.item_date)


            userObject.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    user = dataSnapshot.getValue(Person::class.java)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle errors here
                }
            })
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewHolder {

        // have a CardViewHolder created when needed
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout_check, viewGroup, false)
        return CardViewHolder(view)

    }


    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {

        //val donationData = returnDonationDataClass(keys!![position])
        if(user?.dentist != null) {
            val currentView:Activity = user?.dentist!![position]
            val encodedImage = currentView.image
            if(encodedImage.equals("")) {
                viewHolder.imageView?.setImageResource(R.drawable.tooth)
            } else {
                val decodedBytes = Base64.decode(encodedImage, Base64.DEFAULT)
                val decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                viewHolder.imageView?.setImageBitmap(decodedBitmap)
            }

            viewHolder.date?.text = currentView.date

        }
    }




    // get the number of elements
    override fun getItemCount(): Int {
        return user?.dentist!!.size
    }
}