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

    @GET("yemekler/tum_sepet_yemekler.php")
    fun getAllCartFoods() : Call<FoodResponse>

    @POST("yemekler/insert_sepet_yemek.php")
    @FormUrlEncoded
    fun insertCartFood(@Field("yemek_adi") name : String,
                     @Field("yemek_resim_adi") picture_name : String,
                   @Field("yemek_fiyat") price : Int) : Call<CRUDResponse>


    @POST("yemekler/delete_sepet_yemek.php")
    @FormUrlEncoded
    fun deleteCartFood(@Field("yemek_id") id : Int) : Call<CRUDResponse>


    @POST("yemekler/tum_yemekler_arama.php")
    @FormUrlEncoded
    fun searchFood(@Field("yemek_adi") name: String) : Call<FoodResponse>

}