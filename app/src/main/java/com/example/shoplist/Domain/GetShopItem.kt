package com.example.shoplist.Domain

class GetShopItemUseCase(val repository: ShopListRepository){

    fun getShopItem(id: Int): ShopItem {
        return repository.getShopItem(id)
    }

}