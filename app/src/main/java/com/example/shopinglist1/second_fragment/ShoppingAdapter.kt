package com.example.shopinglist1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter(var list:  List<ShoppingItems>, val shoppingItemClickInterface: ShopppingItemClickInterface, private val vm:ShoppingViewModel): RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>()
 {

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTv = itemView.findViewById<TextView>(R.id.idTvItemName)
        val quantityTv = itemView.findViewById<TextView>(R.id.idTvQuantity)
        val rateTv = itemView.findViewById<TextView>(R.id.idTvRate)
        val amountTv = itemView.findViewById<TextView>(R.id.idTvAmount)
        val deleteTv = itemView.findViewById<ImageView>(R.id.idIvDelete)
    }

    interface ShopppingItemClickInterface{
        fun onItemClick(shoppingItems: ShoppingItems)
    }

     override fun onCreateViewHolder(
         parent: ViewGroup,
         viewType: Int
     ): ShoppingAdapter.ShoppingViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_item, parent, false)
         return ShoppingViewHolder(view)
     }

     //Take entire list and assigns it to Shopping Fragment
     fun getProducts() : List<ShoppingItems> {
         return list
     }

     // Responsible for bidning the elements to the data
     override fun onBindViewHolder(holder: ShoppingAdapter.ShoppingViewHolder, position: Int) {
         holder.nameTv.text = list.get(position).itemName
         holder.quantityTv.text = list.get(position).itemQuantity.toString()
         holder.rateTv.text = list.get(position).itemPrice.toString()
         val itemTotal : Int = list.get(position).itemPrice*list.get(position).itemQuantity
         holder.amountTv.text = "$ " + itemTotal.toString()
         holder.deleteTv.setOnClickListener {
             // get(position) jest pobraniem pozycji danego elementu
             vm.delete(list.get(position))
         }
     }


     override fun getItemCount(): Int {
         return list.size
     }
 }