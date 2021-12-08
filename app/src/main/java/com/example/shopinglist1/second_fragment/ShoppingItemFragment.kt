package com.example.shopinglist1

import android.graphics.LinearGradient
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopinglist1.databinding.ActivityMainBinding
import com.example.shopinglist1.databinding.FragmentShoppingItemBinding
import com.example.shopinglist1.room.ShoppingItemsConnection
import org.pondar.dialogfragmentdemokotlinnew.AddRangeDialog
import kotlin.math.log

class ShoppingItemFragment : Fragment(), ShoppingAdapter.ShopppingItemClickInterface {
    var list: List<ShoppingItems> = emptyList()
    var pickedList: List<ShoppingItemsConnection> = emptyList()

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

        val position = arguments?.getString("position")
        val name = arguments?.getString("name")

        positionValue = position.toString()
        nameValue = name.toString()

        binding.toolbar.TvListName.text = nameValue


        Log.d("id", "$position,$name")

        val shoppingRepo = ShoppingRepo(ShoppingDataBase(requireContext()))
        val factory = ShoppingViewModelFactory(shoppingRepo)
        shoppingViewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        shoppingAdapter =  ShoppingAdapter(list, this, shoppingViewModel)
        binding.IdRvItem.layoutManager = LinearLayoutManager(context)
        binding.IdRvItem.adapter = shoppingAdapter

        // Tutaj pobierzmy z rooma baze danych z gotową relacją
//        if(positionValue.toInt() == 0){
//            positionValue = "1"
//        }

        shoppingViewModel.getAllPickedShoppingItems(position!!.toInt()).observe(viewLifecycleOwner, Observer {
//            shoppingAdapter.list = it.shoppingList
//            shoppingAdapter.notifyDataSetChanged()
            if(it == null || it.shoppingList.isEmpty()) {
                it?.shoppingList = emptyList()
                shoppingAdapter.list = emptyList()
            }else {
                shoppingAdapter.list = it.shoppingList
            }
            shoppingAdapter.notifyDataSetChanged()

        })
        binding.idFABadd.setOnClickListener {
            AddRangeDialog(requireContext(), object: ShoppingAdapter.ShopppingItemClickInterface {
                override fun onItemClick(shoppingItems: ShoppingItems) {
                    shoppingViewModel.insert(shoppingItems)
                }
            }).show()
        }
        // this biding is responsible for taking all items from a certain list and deletes all of the records
        // It deletes the records by id
        binding.toolbar.deleteAll.setOnClickListener {
            shoppingViewModel.deleteByIdShoppingWithProducts(shoppingAdapter.getProducts().map { it.id })
        }
        binding.toolbar.idIvHome.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_shoppingItemFragment_to_mainFragment)
        }
    }

    override fun onItemClick(shoppingItems: ShoppingItems) {
        shoppingViewModel.delete(shoppingItems)
        shoppingAdapter.notifyDataSetChanged()
        Toast.makeText(context, "Item deleted...", Toast.LENGTH_SHORT)
    }


    companion object {
        var positionValue = ""
        var nameValue = ""
    }

}