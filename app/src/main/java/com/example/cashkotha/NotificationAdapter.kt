package com.example.cashkotha

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NotificationAdapter(
    private val context: Context,
    private val notifications: List<Notification>
) : ArrayAdapter<Notification>(context, 0, notifications) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_notification, parent, false)

        val notification = notifications[position]

        val title = itemView.findViewById<TextView>(R.id.notification_title)
        val message = itemView.findViewById<TextView>(R.id.notification_message)
        val time = itemView.findViewById<TextView>(R.id.notification_timestamp)

        title.text = notification.title
        message.text = notification.message
        time.text = notification.timestamp

        return itemView
    }
}