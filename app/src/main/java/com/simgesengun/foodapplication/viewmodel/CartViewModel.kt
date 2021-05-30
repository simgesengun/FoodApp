package com.simgesengun.foodapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import com.simgesengun.foodapplication.entity.CartFood
import com.simgesengun.foodapplication.entity.Food

class CartViewModel : ViewModel() {

    var cartFoodsList = MutableLiveData<List<CartFood>>()
    var postReference : DatabaseReference
    var totalPrice = MutableLiveData<Int>()
    val db : FirebaseDatabase

    init {
        db = FirebaseDatabase.getInstance()
        postReference = db.getReference("cart_foods")
        totalPrice.value = 0

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val list = arrayListOf<CartFood>()
                var number = 0
                for (data : DataSnapshot in dataSnapshot.children){
                    val food = data.getValue(CartFood::class.java)
                    if (food!=null){
                        list.add(food)
                        number += food.order_number!! * food.price!!
                    }

                }
                totalPrice.value = number
                cartFoodsList.value = list
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        postReference.addValueEventListener(postListener)

    }


}