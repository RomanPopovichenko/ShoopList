package com.example.shoplist.Domain

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNEXPECTED_ID
) {

    companion object {

        const val UNEXPECTED_ID = -1

    }

}