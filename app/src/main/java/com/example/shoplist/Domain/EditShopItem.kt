package com.example.shoplist.Domain

class EditShopItem(val repository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        repository.editShopItem(shopItem)
    }

}