package com.simgesengun.foodapplication.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Food (@SerializedName("yemek_id")
                    @Expose
                    var id : Int,
                    @SerializedName("yemek_adi")
                    @Expose
                    var name : String,
                    @SerializedName("yemek_resim_adi")
                    @Expose
                    var picture_name : String,
                    @SerializedName("yemek_fiyat")
                    @Expose
                    var price : Int) : Serializable {
}