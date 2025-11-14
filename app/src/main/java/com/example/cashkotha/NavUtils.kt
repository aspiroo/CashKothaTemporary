package com.example.cashkotha.utils

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.startActivity
import com.example.cashkotha.*
import com.google.android.material.bottomnavigation.BottomNavigationView

// Toast helper
fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun setupBackArrow(activity: AppCompatActivity, toolbar: Toolbar) {
    activity.setSupportActionBar(toolbar)
    activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    activity.supportActionBar?.setDisplayShowHomeEnabled(true)

    toolbar.setNavigationOnClickListener {
        activity.onBackPressedDispatcher.onBackPressed()
        // Or finish() if you just want to close
    }
}

fun setupBottomNav(activity: AppCompatActivity, navView: BottomNavigationView) {
    when (activity) {
        is HomeActivity -> navView.selectedItemId = R.id.nav_home
        is CalculatorActivity -> navView.selectedItemId = R.id.nav_calculator
        is DiscountsActivity -> navView.selectedItemId = R.id.nav_discounts
        // add other activities if needed
    }

    navView.setOnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                if (activity !is HomeActivity) {
                    activity.startActivity(Intent(activity, HomeActivity::class.java))
                }
                true
            }
            R.id.nav_calculator -> {
                if (activity !is CalculatorActivity) {
                    activity.startActivity(Intent(activity, CalculatorActivity::class.java))
                }
                true
            }
            R.id.nav_transactions -> {
                Toast.makeText(activity, "Transactions clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_goals -> {
                Toast.makeText(activity, "Goals clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_discounts -> {
                if (activity !is DiscountsActivity) {
                    activity.startActivity(Intent(activity, DiscountsActivity::class.java))
                }
                true
            }
            R.id.nav_ai_advisor -> {
                Toast.makeText(activity, "AI Advisor clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}