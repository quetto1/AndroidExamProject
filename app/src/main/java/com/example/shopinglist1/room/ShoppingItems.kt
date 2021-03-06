package com.example.shopinglist1

//Room imported functionalities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Initiating variables in table using  Room (Entities)
@Entity(tableName = "shopping_items")
data class ShoppingItems (
    @ColumnInfo(name = "itemName")
    var itemName: String,

    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,

    @ColumnInfo(name = "itemPrice")
    var itemPrice: Int,

    @ColumnInfo(name = "shopOwnerId")
    val shopOwnerId : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}


