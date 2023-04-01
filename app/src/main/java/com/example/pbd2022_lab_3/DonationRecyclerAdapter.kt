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

class DonationRecyclerAdapter(context: Context): RecyclerView.Adapter<DonationRecyclerAdapter.CardViewHolder>(){

    private var sharedPreferences:SharedPreferences? = context.getSharedPreferences("blood_donation", Context.MODE_PRIVATE)
    private var keys: List<String>? = sharedPreferences?.all?.keys?.toList()


    inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var imageView:ImageView? = null
        var date: TextView? = null
        init {

            imageView = itemView?.findViewById(R.id.item_image)
            date = itemView?.findViewById(R.id.item_date)
            Log.d("hello", "hello")
            Log.d("sharedPref", keys.toString())
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewHolder {

        // have a CardViewHolder created when needed
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout_donate, viewGroup, false)
        return CardViewHolder(view)

    }

    private fun returnDonationDataClass(key: String) :DonationDataClass {

        val json = sharedPreferences?.getString(key, null)
        val gson = Gson()
        return gson.fromJson(json, DonationDataClass::class.java)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {

        val donationData = returnDonationDataClass(keys!![position])

        val encodedImage = donationData.image
        if(encodedImage.equals("placeholder")) {
            viewHolder.imageView?.setImageResource(R.drawable.drop_shape)
        } else {
            val decodedBytes = Base64.decode(encodedImage, Base64.DEFAULT)
            val decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
            viewHolder.imageView?.setImageBitmap(decodedBitmap)
        }
        Log.d("hereWeAre", donationData.toString())
        viewHolder.date?.text = donationData.date
    }


    // get the number of elements
    override fun getItemCount(): Int {
        return keys!!.size
    }
}