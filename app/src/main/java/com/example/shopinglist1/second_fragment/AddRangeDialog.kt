package org.pondar.dialogfragmentdemokotlinnew


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

class AddRangeDialog(
    context: Context,
    var shoppingItemClickInterface: ShoppingAdapter.ShopppingItemClickInterface
) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_range_dialog)
//        binding = AddRangeDialogBinding.inflate(layoutInflater)
        val addButton = findViewById<Button>(R.id.addButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val itemNameText = findViewById<EditText>(R.id.textView)
        val itemQuantityText = findViewById<EditText>(R.id.editTextStart)
        val itemPriceText = findViewById<EditText>(R.id.textView2)


        addButton?.setOnClickListener {
            val itemName = itemNameText?.text.toString()
            val itemQuantity = itemQuantityText?.text.toString()
            val itemPrice = itemPriceText?.text.toString()

            if (itemName.isEmpty() || itemQuantity.isEmpty() || itemPrice.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val item = ShoppingItems(itemName, itemQuantity.toInt(), itemPrice.toInt())
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



