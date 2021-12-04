package com.example.shopinglist1


class ShoppingRepo(private val db:ShoppingDataBase) {

    suspend fun insert(items: ShoppingItems) = db.getShoppingDao().insert(items)
    suspend fun delete(items: ShoppingItems) = db.getShoppingDao().delete(items)

    fun getAllItems()= db.getShoppingDao().getAllShoppingItems()
}