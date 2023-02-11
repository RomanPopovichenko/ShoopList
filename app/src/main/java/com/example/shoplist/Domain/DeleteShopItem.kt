package com.example.shoplist.Domain

class DeleteShopItem(val repository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        repository.deleteShopItem(shopItem)
    }

}