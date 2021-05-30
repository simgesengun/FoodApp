package com.simgesengun.foodapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.simgesengun.foodapplication.databinding.CardDesignBinding
import com.simgesengun.foodapplication.databinding.CartCardDesignBinding
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.fragment.CartFragmentDirections
import com.simgesengun.foodapplication.fragment.HomepageFragmentDirections
import com.simgesengun.foodapplication.viewmodel.CartViewModel


class CartFoodAdapter (var mContext : Context, var cartFoodsList : List<Food>) :
        RecyclerView.Adapter<CartFoodAdapter.CartFoodCardDesignHolder>() {

    inner class CartFoodCardDesignHolder(cartCardDesignBinding: CartCardDesignBinding) : RecyclerView.ViewHolder(cartCardDesignBinding.root){
        var design : CartCardDesignBinding

        init {
            this.design = cartCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartFoodCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CartCardDesignBinding.inflate(layoutInflater, parent, false)

        return CartFoodCardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CartFoodCardDesignHolder, position: Int) {
        val db = FirebaseDatabase.getInstance()
        val postReference = db.getReference("cart_foods")
        
        val food = cartFoodsList.get(position)
        holder.design.cartFood = food

        val newRef = db.getReference("cart_foods/" + food.id.toString())
        
        holder.design.imageViewUp.setOnClickListener {
            val number = Integer.valueOf(holder.design.editTextNumber.text.toString()) + 1
            holder.design.editTextNumber.setText(number.toString())
        }
        holder.design.imageViewDown.setOnClickListener {
            var number = Integer.valueOf(holder.design.editTextNumber.text.toString())
            if (number>1){
                number -=1
            }
            holder.design.editTextNumber.setText(number.toString())
        }
        holder.design.editTextNumber.doOnTextChanged { text, _, _, _ ->
            newRef.child("number").setValue(Integer.valueOf(text.toString()))
        }
        

        holder.design.imageViewDelete.setOnClickListener {
            newRef.removeValue()
        }

        holder.design.cardView.setOnClickListener {
            val nav = CartFragmentDirections.toDetails(food)
            Navigation.findNavController(it).navigate(nav)
        }
    }


    override fun getItemCount(): Int {
        return cartFoodsList.size
    }
}