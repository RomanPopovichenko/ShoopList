package com.example.shoplist.Presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shoplist.R

class ShopListViewHolder(val view: View): ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val tvCount = view.findViewById<TextView>(R.id.tvCount)
}