package com.simgesengun.foodapplication

import java.io.Serializable

data class Item(var id : Int, var name : String, var price : Double, var picture_name : String) :Serializable {
}