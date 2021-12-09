package com.example.shopinglist1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//Responsible for init the view model
class ShoppingViewModelFactory(private val repository: ShoppingRepo) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}
