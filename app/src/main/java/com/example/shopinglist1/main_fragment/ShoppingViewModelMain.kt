package com.example.shopinglist1.main_fragment

import androidx.lifecycle.ViewModel
import com.example.shopinglist1.ShoppingItems
import com.example.shopinglist1.ShoppingRepo
import com.example.shopinglist1.room.ShoppingItemsMain
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModelMain(private val repo: ShoppingRepo): ViewModel() {
    fun insert(items: ShoppingItemsMain) = GlobalScope.launch {
        repo.insertMain(items)
    }

    fun delete(items: ShoppingItemsMain) = GlobalScope.launch {
        repo.deleteMain(items)
    }

    fun getAllShoppingItemsMain() = repo.getAllItemsMain()
}