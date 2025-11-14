package com.example.cashkotha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DiscountsAdapter(
    private val offers: List<DiscountOffer>,
    private val onOfferClick: (DiscountOffer) -> Unit
) : RecyclerView.Adapter<DiscountsAdapter.DiscountViewHolder>() {

    inner class DiscountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.offerCard)
        val offerImage: ImageView = itemView.findViewById(R.id.offerImage)
        val offerTitle: TextView = itemView.findViewById(R.id.offerTitle)
        val offerDescription: TextView = itemView.findViewById(R.id.offerDescription)

        fun bind(offer: DiscountOffer) {
            offerTitle.text = offer.title
            offerDescription.text = offer.description
            offerImage.setImageResource(offer.imageResource)

            cardView.setOnClickListener {
                onOfferClick(offer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_discount_offer, parent, false)
        return DiscountViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        holder.bind(offers[position])
    }

    override fun getItemCount(): Int = offers.size
}