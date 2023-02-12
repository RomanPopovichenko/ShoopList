package com.example.shoplist.Presentation

import androidx.lifecycle.ViewModel
import com.example.shoplist.Data.ShopListImpl
import com.example.shoplist.Domain.DeleteShopItemUseCase
import com.example.shoplist.Domain.EditShopItemUseCase
import com.example.shoplist.Domain.GetShopListUseCase
import com.example.shoplist.Domain.ShopItem

class MainViewModel: ViewModel() {

    val repository = ShopListImpl

    val getShopList = GetShopListUseCase(repository)
    val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    val editShopItem = EditShopItemUseCase(repository)

    val shopList = getShopList.getShopList()

    fun editShopItem(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItem.editShopItem(newShopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

}