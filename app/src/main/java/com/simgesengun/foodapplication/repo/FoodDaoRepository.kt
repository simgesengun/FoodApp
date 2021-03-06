package com.simgesengun.foodapplication.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.simgesengun.foodapplication.entity.*
import com.simgesengun.foodapplication.retrofit.FoodDaoInterface
import com.simgesengun.foodapplication.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDaoRepository {
    private val foodsList : MutableLiveData<List<Food>>
    private val fdaoi : FoodDaoInterface

    init{
        fdaoi = ApiUtils.getFoodDaoInterface()
        foodsList = MutableLiveData()
    }

    fun getFoodsList() : MutableLiveData<List<Food>> {
        return foodsList
    }


    fun getAllFoods() {
        fdaoi.getAllFoods().enqueue(object : Callback<FoodResponse> {
            override fun onResponse(call: Call<FoodResponse>?, response: Response<FoodResponse>) {
                val list = response.body().foods_list
                foodsList.value = list
            }

            override fun onFailure(call: Call<FoodResponse>?, t: Throwable?) {
            }
        })
    }

    fun searchFood(search: String) {
        fdaoi.searchFood(search).enqueue(object : Callback<FoodResponse> {
            override fun onResponse(call: Call<FoodResponse>?, response: Response<FoodResponse>) {
                val list = response.body().foods_list
                foodsList.value = list
            }

            override fun onFailure(call: Call<FoodResponse>?, t: Throwable?) {}
        })
    }
}