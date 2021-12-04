package com.example.shopinglist1.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopinglist1.ShoppingItems

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItems)

    @Delete
    suspend fun  delete(item: ShoppingItems)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems():LiveData<List<ShoppingItems>>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMain(item: ShoppingItemsMain)

    @Delete
    suspend fun  deleteMain(item: ShoppingItemsMain)

    @Query("SELECT * FROM shopping_items_main")
    fun getAllShoppingItemsMain():LiveData<List<ShoppingItemsMain>>
}