package com.example.shopinglist1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopinglist1.room.ShoppingDao
import com.example.shopinglist1.room.ShoppingItemsMain

@Database(entities = [ShoppingItems::class, ShoppingItemsMain::class], version = 1)
abstract class ShoppingDataBase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    // object responsible for checking if there is a database
    companion object {
        @Volatile
        private var instance: ShoppingDataBase? = null
        private val LOCK = Any()

        // invoke function is responsible for initialize the database
        // if the database is empty lunch "synchronized(LOCK)"
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDataBase::class.java,
                "Shopping.DB"
            ).build()

    }


}
