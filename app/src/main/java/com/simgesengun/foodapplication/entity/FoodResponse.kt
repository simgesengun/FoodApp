package com.simgesengun.foodapplication.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FoodResponse(@SerializedName("yemekler")
                          @Expose
                          var foods_list : List<Food>,
                        @SerializedName("success")
                          @Expose
                          var success : Int) {
}