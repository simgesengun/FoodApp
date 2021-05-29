package com.simgesengun.foodapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.repo.FoodDaoRepository

class HomepageViewModel : ViewModel() {

    var foodsList = MutableLiveData<List<Food>>()
    val fdaor = FoodDaoRepository()

    init {
        loadFoods()
        foodsList = fdaor.getFoodsList()

    }

    fun loadFoods(){
        fdaor.getAllFoods()
    }

    fun loadCartFoods(){
        fdaor.getAllCartFoods()
    }

    fun deleteCartFood(id : Int){
        fdaor.deleteCartFood(id)
    }

    fun searchFood(search : String){
        fdaor.searchFood(search)
    }
}