package com.simgesengun.foodapplication.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Food (@SerializedName("yemek_id")
                    @Expose
                    var id : Int? = null,
                    @SerializedName("yemek_adi")
                    @Expose
                    var name : String? = null,
                    @SerializedName("yemek_resim_adi")
                    @Expose
                    var picture_name : String? = null,
                    @SerializedName("yemek_fiyat")
                    @Expose
                    var price : Int? = null,
                    @SerializedName("yemek_siparis_adet")
                     @Expose
                     var number : Int? = null) : Serializable {
}