package com.example.shopinglist1.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items_main")
data class ShoppingItemsMain (
    @ColumnInfo(name = "itemNameMain")
    var itemNameMain: String,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
