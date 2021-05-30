package com.simgesengun.foodapplication.retrofit

import com.simgesengun.foodapplication.entity.CRUDResponse
import com.simgesengun.foodapplication.entity.FoodResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDaoInterface {
    @GET("yemekler/tum_yemekler.php")
    fun getAllFoods() : Call<FoodResponse>

    @POST("yemekler/tum_yemekler_arama.php")
    @FormUrlEncoded
    fun searchFood(@Field("yemek_adi") name: String) : Call<FoodResponse>

}