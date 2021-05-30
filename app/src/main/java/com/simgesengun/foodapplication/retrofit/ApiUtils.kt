package com.simgesengun.foodapplication.retrofit

import com.simgesengun.foodapplication.retrofit.RetrofitClient.Companion.getClient

class ApiUtils {
    companion object{
        val BASE_URL : String = "http://kasimadalan.pe.hu/"

        fun getFoodDaoInterface() : FoodDaoInterface {
            return getClient(BASE_URL).create(FoodDaoInterface::class.java)
        }
    }
}