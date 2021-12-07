package com.example.shopinglist1

import com.example.shopinglist1.room.ShoppingItemsMain


//Shopping repo is responsible for initiating functions responsible for pushing,deleting and geting the records from the database
class ShoppingRepo(private val db:ShoppingDataBase) {

    suspend fun insert(items: ShoppingItems) = db.getShoppingDao().insert(items)
    suspend fun delete(items: ShoppingItems) = db.getShoppingDao().delete(items)

    fun getAllItems()= db.getShoppingDao().getAllShoppingItems()


    suspend fun insertMain(items: ShoppingItemsMain) = db.getShoppingDao().insertMain(items)
    suspend fun deleteMain(items: ShoppingItemsMain) = db.getShoppingDao().deleteMain(items)

    fun getAllItemsMain()= db.getShoppingDao().getAllShoppingItemsMain()
}