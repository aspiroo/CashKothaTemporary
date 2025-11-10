package com.example.cashkotha

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TransactionAdapter(
    private val context: Context,
    private val transactions: List<Transaction>
) : ArrayAdapter<Transaction>(context, 0, transactions) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_transaction, parent, false)
        }

        val transaction = transactions[position]

        val title = itemView!!.findViewById<TextView>(R.id.transaction_title)
        val time = itemView.findViewById<TextView>(R.id.transaction_timestamp)
        val amount = itemView.findViewById<TextView>(R.id.transaction_amount)

        title.text = transaction.title
        time.text = transaction.timestamp
        amount.text = transaction.amount

        return itemView
    }
}