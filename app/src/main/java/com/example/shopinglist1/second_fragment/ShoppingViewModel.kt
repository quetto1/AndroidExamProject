package com.example.shopinglist1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.os.Bundle




// Class responsible for creating functions for the queries (Hook to the shopping repo)
class ShoppingViewModel(private val repo: ShoppingRepo): ViewModel() {

    fun insert(items: ShoppingItems) = GlobalScope.launch {
        repo.insert(items)
    }

    fun delete(items: ShoppingItems) = GlobalScope.launch {
        repo.delete(items)
    }

    fun getAllShoppingItems() = repo.getAllItems()

    fun getAllPickedShoppingItems(id:Int) = repo.getAllItemsFromPickedList(id)

    fun deleteByIdShoppingWithProducts(id: List<Int>) = repo.deleteByIdShoppingWithProducts(id)

}