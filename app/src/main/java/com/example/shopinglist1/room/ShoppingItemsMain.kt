package com.example.shopinglist1.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Initiating variables in table using Room Database
@Entity(tableName = "shopping_items_main")
data class ShoppingItemsMain (
    //Column with  Item Name
    @ColumnInfo(name = "itemNameMain")
    var itemNameMain: String,

) {
    // Creates a column with unique id
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
