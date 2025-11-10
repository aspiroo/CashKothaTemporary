package com.example.cashkotha

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cashkotha.databinding.ActivityHomeBinding
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.LinearLayout

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var transactionsList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // --- Tabs ---
        val generalTab = findViewById<TextView>(R.id.general_tab)
        val transactionsTab = findViewById<TextView>(R.id.transactions_tab)
        val budgetTab = findViewById<TextView>(R.id.budget_tab)

        // --- Layouts for each tab content ---
        val generalLayout = findViewById<LinearLayout>(R.id.general_layout)
        val transactionsLayout = findViewById<LinearLayout>(R.id.transactions_layout)
        val budgetLayout = findViewById<LinearLayout>(R.id.budget_layout)

        // --- Function to show selected layout ---
        fun showTab(selectedLayout: LinearLayout) {
            generalLayout.visibility = LinearLayout.GONE
            transactionsLayout.visibility = LinearLayout.GONE
            budgetLayout.visibility = LinearLayout.GONE

            selectedLayout.visibility = LinearLayout.VISIBLE
        }

        // --- Function to highlight selected tab ---
        fun highlightTab(selectedTab: TextView) {
            generalTab.setBackgroundResource(R.drawable.tab_background_unselected)
            transactionsTab.setBackgroundResource(R.drawable.tab_background_unselected)
            budgetTab.setBackgroundResource(R.drawable.tab_background_unselected)

            generalTab.setTextColor(Color.parseColor("#052224"))
            transactionsTab.setTextColor(Color.parseColor("#052224"))
            budgetTab.setTextColor(Color.parseColor("#052224"))

            selectedTab.setBackgroundResource(R.drawable.tab_background_selected)
            selectedTab.setTextColor(Color.BLACK)
        }

        // --- Tab click listeners ---
        generalTab.setOnClickListener {
            showTab(generalLayout)
            highlightTab(generalTab)
        }

        transactionsTab.setOnClickListener {
            showTab(transactionsLayout)
            highlightTab(transactionsTab)
        }

        budgetTab.setOnClickListener {
            showTab(budgetLayout)
            highlightTab(budgetTab)
        }

        // Find the ListView
        transactionsList = findViewById(R.id.transactions_list)


        // Example data
        val transactions = listOf(
            Transaction("Salary", "18:27 - April 30", "100000 TK"),
            Transaction("Dinner", "20:45 - May 1", "-500 TK"),
            Transaction("Freelance", "09:00 - May 2", "20000 TK")
        )

        // Use a custom adapter
        val adapter = TransactionAdapter(this, transactions)
        transactionsList.adapter = adapter


        // Example: BottomNavigationView listener
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> { /* handle home */
                    showToast("Home clicked")
                    true
                }

                R.id.nav_transactions -> { /* handle transactions */
                    showToast("Transactions clicked")
                    true
                }
                R.id.nav_analysis -> { /* handle budget */
                    showToast("Analysis clicked")
                    true
                }
                R.id.nav_category -> { /* handle budget */
                    showToast("Category clicked")
                    true
                }
                R.id.nav_profile -> { /* handle budget */
                    showToast("Profile clicked")
                    true
                }
                else -> false
            } as Boolean
        }

        val notificationIcon = findViewById<ImageView>(R.id.notification_icon)
        notificationIcon.setOnClickListener {
            // Handle click here
            showToast("Notification icon clicked")
        }

    }

    // Helper function to show a message
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

