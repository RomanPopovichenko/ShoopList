package com.example.shoplist.Domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(val repository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return repository.getShopList()
    }

}