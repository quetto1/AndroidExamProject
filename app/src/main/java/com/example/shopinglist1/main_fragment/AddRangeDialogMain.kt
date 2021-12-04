package com.example.shopinglist1.main_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shopinglist1.R
import com.example.shopinglist1.ShoppingAdapter
import com.example.shopinglist1.ShoppingItems
import com.example.shopinglist1.room.ShoppingItemsMain

class AddRangeDialogMain(
    context: Context,
    var shoppingItemClickInterface: ShoppingAdapterMain.ShopppingItemClickInterface
) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_range_dialog_main)
        val addButton = findViewById<Button>(R.id.addButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val itemNameText = findViewById<EditText>(R.id.textView)



        addButton?.setOnClickListener {
            val itemNameMain = itemNameText?.text.toString()


            val item = ShoppingItemsMain(itemNameMain)
            shoppingItemClickInterface.onItemClick(item)
            dismiss()
            Log.d("dialog", "Add Dialog")
        }

        cancelButton?.setOnClickListener {
            cancel()
            Log.d("dialog", "Cancel Dialog")
        }
    }
}