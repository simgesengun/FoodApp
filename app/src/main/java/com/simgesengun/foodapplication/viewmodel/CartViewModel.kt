package com.simgesengun.foodapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.repo.FoodDaoRepository

class CartViewModel : ViewModel() {

    var cartFoodsList = MutableLiveData<List<Food>>()
    var postReference : DatabaseReference
    var totalPrice = MutableLiveData<Int>()
    val db : FirebaseDatabase

    init {
        // Firebase
        db = FirebaseDatabase.getInstance()
        postReference = db.getReference("cart_foods")
        totalPrice.value = 0
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val list = arrayListOf<Food>()
                var number = 0
                for (data : DataSnapshot in dataSnapshot.children){
                    val food : Food = data.getValue(Food::class.java)!!
                    list.add(food)
                    Log.e("price",food.price.toString())
                    Log.e("number",food.number.toString())
                    number += food.price!! * food.number!!

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