package com.simgesengun.foodapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.google.firebase.database.FirebaseDatabase
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.repo.FoodDaoRepository

class DetailsViewModel : ViewModel() {
    var number = MutableLiveData<Int>()
    var db : FirebaseDatabase
    init{
        db = FirebaseDatabase.getInstance()
        number.value = 1
    }

    fun cartButtonClicked(food : Food){
        val newRef = db.getReference("cart_foods/"+ food.id.toString())
        val temp = food
        newRef.get().addOnSuccessListener {
            if(it.exists()){
                if (it.child("number").value != null){
                    temp.number = it.child("number").getValue(Int::class.java)!! + number.value!!
                }
                newRef.setValue(temp)
            }
            else{
                temp.number = number.value
                newRef.setValue(temp)
            }
        }


    }
    fun numberUp(){
        number.value = number.value!! + 1
    }
    fun numberDown(){
        number.value = number.value!! - 1
    }

}