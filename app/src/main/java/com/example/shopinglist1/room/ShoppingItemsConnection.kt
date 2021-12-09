package com.example.shopinglist1.room

import androidx.room.Embedded
import androidx.room.Relation
import com.example.shopinglist1.ShoppingItems
import com.example.shopinglist1.room.ShoppingItemsMain

// Responsible for Initializing a relation between 2 tables
data class ShoppingItemsConnection (
    @Embedded
    val shoppingItemsMain: ShoppingItemsMain,
    @Relation(
        parentColumn = "id",
        entityColumn = "shopOwnerId"
    )
    var shoppingList: List<ShoppingItems> = emptyList()
)