package com.example.cashkotha

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashkotha.databinding.ActivityDiscountsBinding
import com.example.cashkotha.utils.setupBackArrow
import com.example.cashkotha.utils.setupBottomNav

class DiscountsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiscountsBinding
    private lateinit var discountsAdapter: DiscountsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiscountsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBackArrow(this, binding.toolbar)
        setupBottomNav(this, binding.bottomNavigationView)

        // Initialize RecyclerView
        recyclerView = binding.discountsRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        // Create sample discount offers (you can replace these later)
        val discountOffers = createSampleOffers()

        // Set up adapter with click listener
        discountsAdapter = DiscountsAdapter(discountOffers) { offer ->
            openOfferUrl(offer)
        }
        recyclerView.adapter = discountsAdapter
    }

    private fun createSampleOffers(): List<DiscountOffer> {
        return listOf(
            DiscountOffer(
                id = 1,
                title = "Daraz",
                description = "Up to 50% Off",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://s.daraz.com.bd/s.0XD5C"
            ),
            DiscountOffer(
                id = 2,
                title = "bKash",
                description = "10% Cashback",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://www.bkash.com/en/campaign"
            ),
            DiscountOffer(
                id = 3,
                title = "Foodpanda",
                description = "Free Delivery",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://www.foodpanda.com.bd"
            ),
            DiscountOffer(
                id = 4,
                title = "Pathao",
                description = "20% Off on Rides",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://pathao.com/blog/category/offers-promos/"
            ),
            DiscountOffer(
                id = 5,
                title = "Nagad",
                description = "5% Cashback",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://nagad.com.bd/campaigns/"
            ),
            DiscountOffer(
                id = 6,
                title = "Chaldal",
                description = "15% Off",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://chaldal.com/offers?srsltid=AfmBOop0kZfqt9pY7uiwtAoRlp8Zb-OPpmTPkRevgLGg0PVaHD2bfoqe"
            ),
            DiscountOffer(
                id = 7,
                title = "Uber",
                description = "First Ride Free",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://www.uber.com"
            ),
            DiscountOffer(
                id = 8,
                title = "Shohoz",
                description = "10% Discount",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://www.shohoz.com/deals-and-offers"
            ),
            DiscountOffer(
                id = 9,
                title = "Ajkerdeal",
                description = "Buy 1 Get 1",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://m.ajkerdeal.com/bkash_new/home.aspx"
            ),
            DiscountOffer(
                id = 10,
                title = "Rokomari",
                description = "20% Off on Books",
                imageResource = R.drawable.ic_placeholder_offer,
                url = "https://www.rokomari.com/offer"
            )
        )
    }

    private fun openOfferUrl(offer: DiscountOffer) {
        if (offer.url.isNotEmpty()) {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(offer.url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Could not open link", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No link available for ${offer.title}", Toast.LENGTH_SHORT).show()
        }
    }
}

// Data class for discount offers
data class DiscountOffer(
    val id: Int,
    val title: String,
    val description: String,
    val imageResource: Int, // You can replace this with SVG path later
    val url: String
)