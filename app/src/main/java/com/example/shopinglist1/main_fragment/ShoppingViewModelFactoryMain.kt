package com.example.shopinglist1.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopinglist1.ShoppingRepo
import com.example.shopinglist1.ShoppingViewModel

class ShoppingViewModelFactoryMain(private val repository: ShoppingRepo) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModelMain(repository) as T
    }
}
