package com.simgesengun.foodapplication.entity

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@IgnoreExtraProperties
data class CartFood (var id : Int? = 0,
                     var name : String? = "",
                     var picture_name : String? = "",
                     var price : Int? = 0,
                     var order_number : Int ?= 0) : Serializable {

}