package com.example.shopinglist1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopinglist1.databinding.FragmentMainBinding
import com.example.shopinglist1.databinding.FragmentShoppingItemBinding
import com.example.shopinglist1.main_fragment.AddRangeDialogMain
import com.example.shopinglist1.main_fragment.ShoppingAdapterMain
import com.example.shopinglist1.main_fragment.ShoppingViewModelFactoryMain
import com.example.shopinglist1.main_fragment.ShoppingViewModelMain
import com.example.shopinglist1.room.ShoppingItemsMain
import org.pondar.dialogfragmentdemokotlinnew.AddRangeDialog


class MainFragment : Fragment(), ShoppingAdapterMain.ShopppingItemClickInterface {
    var list: List<ShoppingItemsMain> = emptyList()

    lateinit var binding: FragmentMainBinding
    lateinit var shoppingAdapterMain: ShoppingAdapterMain
    lateinit var shoppingViewModelMain: ShoppingViewModelMain

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shoppingRepo = ShoppingRepo(ShoppingDataBase(requireContext()))
        val factory = ShoppingViewModelFactoryMain(shoppingRepo)
        shoppingViewModelMain = ViewModelProvider(this, factory).get(ShoppingViewModelMain::class.java)
        shoppingAdapterMain =  ShoppingAdapterMain(list, this)
        binding.IdRvItemMain.layoutManager = LinearLayoutManager(context)
        binding.IdRvItemMain.setHasFixedSize(true)
        //Attaching the Adapter  to the view in main fragment
        binding.IdRvItemMain.adapter = shoppingAdapterMain

        // Responsible for checking the changes if there are any render the view again
        shoppingViewModelMain.getAllShoppingItemsMain().observe(viewLifecycleOwner, Observer {
            shoppingAdapterMain.list = it
            shoppingAdapterMain.notifyDataSetChanged()
        })
        binding.idFABaddMain.setOnClickListener {
            AddRangeDialogMain(requireContext(), object: ShoppingAdapterMain.ShopppingItemClickInterface {
                override fun onItemClick(shoppingItemsMain: ShoppingItemsMain) {
                    shoppingViewModelMain.insert(shoppingItemsMain)
                }
            }).show()
        }
    }

    override fun onItemClick(shoppingItemsMain: ShoppingItemsMain) {
        shoppingViewModelMain.delete(shoppingItemsMain)
        shoppingAdapterMain.notifyDataSetChanged()
        Toast.makeText(context, "Item deleted...", Toast.LENGTH_SHORT)

    }


}