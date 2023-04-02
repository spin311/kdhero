package com.example.pbd2022_lab_3

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
class DonationRecyclerAdapter(context: Context): RecyclerView.Adapter<DonationRecyclerAdapter.CardViewHolder>(){

    private var sharedPreferences:SharedPreferences? = context.getSharedPreferences("current_user", Context.MODE_PRIVATE)

    private val user = sharedPreferences?.getString("current_user", "0")
    private val databaseRef = FirebaseDatabase.getInstance("https://zdravko-7bddd-default-rtdb.europe-west1.firebasedatabase.app").reference

    // array of blood donations
    val userRef = databaseRef.child("users").child(user.toString())

    inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var imageView:ImageView? = null
        var date: TextView? = null
        init {

            imageView = itemView?.findViewById(R.id.item_image)
            date = itemView?.findViewById(R.id.item_date)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewHolder {

        // have a CardViewHolder created when needed
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout_donate, viewGroup, false)
        return CardViewHolder(view)

    }
    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {

        //val donationData = returnDonationDataClass(keys!![position])
       // if(don != null) {
         //   val currentView:Activity = don[position]
         //   val encodedImage = currentView.image
          //  if(encodedImage.equals("")) {
            //    viewHolder.imageView?.setImageResource(R.drawable.drop_shape)
         //   } else {
          //      val decodedBytes = Base64.decode(encodedImage, Base64.DEFAULT)
          //      val decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
          //      viewHolder.imageView?.setImageBitmap(decodedBitmap)
          //  }

           // viewHolder.date?.text = currentView.date

       // }
    }




    // get the number of elements
    override fun getItemCount(): Int {
        return 3
    }
}