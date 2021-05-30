package com.simgesengun.foodapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.simgesengun.foodapplication.entity.CartFood
import com.simgesengun.foodapplication.entity.Food

class DetailsViewModel : ViewModel() {
    var number = MutableLiveData<Int>()
    var db : FirebaseDatabase
    init{
        db = FirebaseDatabase.getInstance()
        number.value = 1
    }

    fun cartButtonClicked(food : Food){
        val refCartFood = db.getReference("cart_foods")
        val key = food.id.toString()
        var old_order_number = 0
        val query = refCartFood.orderByKey().equalTo(key)
        query.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(data in snapshot.children){
                    val cartFood = data.getValue(CartFood::class.java)
                    if (cartFood!=null) {
                        old_order_number = cartFood.order_number!!
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                //
            }

        })
        val cartFood = CartFood(food.id,food.name,food.picture_name,food.price,old_order_number + number.value!!)
        refCartFood.child(key).setValue(cartFood)

    }

    fun numberUp(){
        number.value = number.value!! + 1
    }
    fun numberDown(){
        number.value = number.value!! - 1
    }

}