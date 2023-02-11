package com.example.shoplist.Presentation

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shoplist.Domain.ShopItem
import com.example.shoplist.R

class ShopListAdapter() : ListAdapter<ShopItem, ShopListViewHolder>(ShopListDiffItemCallback()){

    val onShopItemClickListener: ((ShopItem) -> Unit)? = null
    val onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val layout = if (viewType == VIEW_TYPE_ENABLED) {
            R.layout.shop_item_enabled
        } else {
            R.layout.shop_item_disabled
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.view.setOnClickListener{
            onShopItemClickListener?.invoke(shopItem)
        }
        holder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 322
        const val VIEW_TYPE_DISABLED = 123
    }

}