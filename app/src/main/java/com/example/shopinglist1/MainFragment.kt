package com.example.shopinglist1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.shopinglist1.databinding.FragmentMainBinding
import com.example.shopinglist1.databinding.FragmentShoppingItemBinding


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding



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
        binding.button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_shoppingItemFragment)
        }
    }


}