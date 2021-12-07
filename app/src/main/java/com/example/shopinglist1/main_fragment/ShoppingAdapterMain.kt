package com.example.shopinglist1.main_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist1.R
import com.example.shopinglist1.ShoppingAdapter
import com.example.shopinglist1.ShoppingItems
import com.example.shopinglist1.ShoppingViewModel
import com.example.shopinglist1.room.ShoppingItemsMain

class ShoppingAdapterMain(var list:  List<ShoppingItemsMain>, val shopppingItemClickInterface: ShopppingItemClickInterface): RecyclerView.Adapter<ShoppingAdapterMain.ShoppingViewHolderMain>()
{


    inner class ShoppingViewHolderMain(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTv = itemView.findViewById<TextView>(R.id.idTvItemName)
        val deleteTv = itemView.findViewById<ImageView>(R.id.idIvDeleteMain)
        val rootView = itemView.rootView
    }


    interface ShopppingItemClickInterface{
        fun onItemClick(shoppingItemsMain: ShoppingItemsMain)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingAdapterMain.ShoppingViewHolderMain {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_item_main, parent, false)
        return ShoppingViewHolderMain(view)
    }

    //  Funkcja przypisuje do adaptera wartości które znajdują się na liście
    override fun onBindViewHolder(holder: ShoppingAdapterMain.ShoppingViewHolderMain, position: Int) {
        holder.nameTv.text = list.get(position).itemNameMain
        holder.deleteTv.setOnClickListener {
            // get(position) jest pobraniem pozycji danego elementu
            shopppingItemClickInterface.onItemClick(list.get(position))
        }

        holder.rootView.setOnClickListener {

            val bundle = bundleOf("position" to position.toString(), "name" to list.get(position).itemNameMain)
            holder.rootView.findNavController().navigate(R.id.action_mainFragment_to_shoppingItemFragment, bundle)
        }

    }

    //funck
    override fun getItemCount(): Int {
        return list.size
    }
}