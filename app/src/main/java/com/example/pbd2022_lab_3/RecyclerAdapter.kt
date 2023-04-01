package com.example.pbd2022_lab_3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pbd2022_lab_3.RecyclerAdapter.CardViewHolder


class RecyclerAdapter(private val achievements: Array<Int>) : RecyclerView.Adapter<CardViewHolder?>() {
    private val titles = arrayOf(
        "Zdravi Influencer",
        "Raziskovalec",
        "Dokumentacija je pomembna",
        "Determninacija",
        "Krvni heroj",
        "Zlati donator",
        "Miljarder zdravja",
        "zobna miška"
        )
    private val details = arrayOf("Delil svoj prvi dogodek z ostalimi.",
        "Obiskal vse tri možne aktivnosti.",
        "Naredil sliko ob dogodku.", "Večkrat obiskal isti dogodek.",
        "V enem letu večkrat doniral kri.", "Doniral kri petkrat.",
        "V top 10% donatorjev.",
        "Bil na rednem zobozdravniškem pregledu."
        )
    private val images = intArrayOf(
        R.drawable.bullhorn,
        R.drawable.adventurer,
        R.drawable.camera,
        R.drawable.countdown,
        R.drawable.bloodtest,
        R.drawable.blooddonation,
        R.drawable.richman,
        R.drawable.mouse)

    inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var itemImage: ImageView? = null
        var itemTitle: TextView? = null
        var itemDetail: TextView? = null

        init {
            Log.d("svitneki", "helo")
            itemImage = itemView?.findViewById(R.id.item_image)
            itemTitle = itemView?.findViewById(R.id.item_title)
            itemDetail = itemView?.findViewById(R.id.item_detail)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewHolder {
        // have a CardViewHolder created when needed
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.achievement_layout, viewGroup, false)


        return CardViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, i: Int) {
        // TODO: set the image, title, and details data

        if(i !in achievements) {
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context, R.color.disabled))
            viewHolder.itemView.isClickable = false
            viewHolder.itemView.alpha = 0.7f
        }
        viewHolder.itemImage?.setImageResource(images[i])
        viewHolder.itemTitle?.text = titles[i]
        viewHolder.itemDetail?.text = details[i]


    }


    override fun getItemCount(): Int {
        return titles.size
    }
}