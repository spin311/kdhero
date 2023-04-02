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
import com.google.gson.Gson

class CheckRecyclerAdapter(context: Context): RecyclerView.Adapter<CheckRecyclerAdapter.CardViewHolder>(){

    private var sharedPreferences:SharedPreferences? = context.getSharedPreferences("userId", Context.MODE_PRIVATE)
    private var sharedPreferencesAll:SharedPreferences? = context.getSharedPreferences("all", Context.MODE_PRIVATE)

    val user = sharedPreferences?.getString("userId", "0")
    val donationsToJson = returnDataFile("all", sharedPreferencesAll!!)


    val don: ArrayList<Activity>? = when(user) {
        "1" -> donationsToJson?.svit1
        "2" -> donationsToJson?.svit2
        "3" -> donationsToJson?.svit3
        else -> null
    }

    inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var imageView:ImageView? = null
        var date: TextView? = null
        init {

            imageView = itemView?.findViewById(R.id.item_image)
            date = itemView?.findViewById(R.id.item_date)
            Log.d("TAG", don?.get(1)?.date.toString())
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewHolder {

        // have a CardViewHolder created when needed
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout_check, viewGroup, false)
        return CardViewHolder(view)

    }


    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {

        //val donationData = returnDonationDataClass(keys!![position])
        if(don != null) {
            val currentView:Activity = don[position]
            val encodedImage = currentView.image
            if(encodedImage.equals("")) {
                viewHolder.imageView?.setImageResource(R.drawable.svit)
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
        return don!!.size
    }
}