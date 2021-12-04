package com.example.shopinglist1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Stworzenie zmiennych w tabeli wykorzystując Rooma (Entities)

@Entity(tableName = "shopping_items")
data class ShoppingItems (
    @ColumnInfo(name = "itemName")
    var itemName: String,

    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,

    @ColumnInfo(name = "itemPrice")
    var itemPrice: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}


