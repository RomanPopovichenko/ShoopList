package com.example.shoplist.Domain

class AddShopItemUseCase(val repository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        repository.addShopItem(shopItem)
    }

}