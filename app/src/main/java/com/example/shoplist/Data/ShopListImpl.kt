package com.example.shoplist.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplist.Domain.ShopItem
import com.example.shoplist.Domain.ShopListRepository

class ShopListImpl: ShopListRepository {

    val shopListLD = MutableLiveData<List<ShopItem>>()

    val shopList = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    var generatedId = 0

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNEXPECTED_ID) {
            shopItem.id = generatedId++
        }
        shopList.add(shopItem)
        update()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        update()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
        update()
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find { it.id == id }?: throw RuntimeException("Shop item id was not find")
    }

    fun update() {
        shopListLD.value = shopList.toList()
    }

}