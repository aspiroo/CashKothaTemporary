package com.example.cashkotha

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.cashkotha.databinding.ActivityNotificationBinding
import com.example.cashkotha.utils.*
class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Example notification data
        val listView: ListView = findViewById(R.id.notificationListView)
        val notifications = listOf(
            Notification("Budget Reminder", "You’re nearing your monthly food budget.", "Today, 4:30 PM"),
            Notification("New Discount!", "20% off at your favorite restaurant.", "Yesterday, 8:15 PM"),
            Notification("Goal Achieved 🎉", "You reached your savings goal of 10,000 TK!", "Nov 10, 10:00 AM") ,
            Notification("New Discount!", "20% off at your favorite restaurant.", "Yesterday, 8:15 PM"),
            Notification("Goal Achieved 🎉", "You reached your savings goal of 10,000 TK!", "Nov 10, 10:00 AM"),
            Notification("Budget Reminder", "You’re nearing your monthly food budget.", "Today, 4:30 PM"),
            Notification("New Discount!", "20% off at your favorite restaurant.", "Yesterday, 8:15 PM"),
            Notification("Goal Achieved 🎉", "You reached your savings goal of 10,000 TK!", "Nov 10, 10:00 AM"),
            Notification("Budget Reminder", "You’re nearing your monthly food budget.", "Today, 4:30 PM"),
            Notification("New Discount!", "20% off at your favorite restaurant.", "Yesterday, 8:15 PM"),
            Notification("Goal Achieved 🎉", "You reached your savings goal of 10,000 TK!", "Nov 10, 10:00 AM")
        )

        setupBottomNav(this, binding.bottomNavigationView)
        setupBackArrow(this, binding.toolbar)


        // ✅ Set adapter
        val adapter = NotificationAdapter(this, notifications)
        listView.adapter = adapter



    }
}