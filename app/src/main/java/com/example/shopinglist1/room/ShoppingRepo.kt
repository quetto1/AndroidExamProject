package com.example.shopinglist1

import com.example.shopinglist1.room.ShoppingItemsMain


class ShoppingRepo(private val db:ShoppingDataBase) {

    suspend fun insert(items: ShoppingItems) = db.getShoppingDao().insert(items)
    suspend fun delete(items: ShoppingItems) = db.getShoppingDao().delete(items)

    fun getAllItems()= db.getShoppingDao().getAllShoppingItems()


    suspend fun insertMain(items: ShoppingItemsMain) = db.getShoppingDao().insertMain(items)
    suspend fun deleteMain(items: ShoppingItemsMain) = db.getShoppingDao().deleteMain(items)

    fun getAllItemsMain()= db.getShoppingDao().getAllShoppingItemsMain()
}