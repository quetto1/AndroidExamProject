package com.example.shopinglist1

import android.graphics.LinearGradient
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopinglist1.databinding.ActivityMainBinding
import com.example.shopinglist1.databinding.FragmentShoppingItemBinding
import org.pondar.dialogfragmentdemokotlinnew.AddRangeDialog

class ShoppingItemFragment : Fragment(), ShoppingAdapter.ShopppingItemClickInterface {
    var list: List<ShoppingItems> = emptyList()

    lateinit var shoppingAdapter: ShoppingAdapter
    lateinit var shoppingViewModel: ShoppingViewModel
    lateinit var binding: FragmentShoppingItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoppingItemBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoppingAdapter =  ShoppingAdapter(list, this)
        binding.IdRvItem.layoutManager = LinearLayoutManager(context)
        binding.IdRvItem.adapter = shoppingAdapter

        val shoppingRepo = ShoppingRepo(ShoppingDataBase(requireContext()))
        val factory = ShoppingViewModelFactory(shoppingRepo)
        val shoppingViewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        shoppingViewModel.getAllShoppingItems().observe(viewLifecycleOwner, Observer {
            shoppingAdapter.list = it
            shoppingAdapter.notifyDataSetChanged()
        })
        binding.idFABadd.setOnClickListener {
            AddRangeDialog(requireContext(), object: ShoppingAdapter.ShopppingItemClickInterface {
                override fun onItemClick(shoppingItems: ShoppingItems) {
                    shoppingViewModel.insert(shoppingItems)
                }
            }).show()
        }

    }

    override fun onItemClick(shoppingItems: ShoppingItems) {
        shoppingViewModel.delete(shoppingItems)
        shoppingAdapter.notifyDataSetChanged()

        Toast.makeText(context, "Item deleted...", Toast.LENGTH_SHORT)

    }



}