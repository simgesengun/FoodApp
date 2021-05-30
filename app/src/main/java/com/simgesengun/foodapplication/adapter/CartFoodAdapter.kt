package com.simgesengun.foodapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnSuccessListener
import com.simgesengun.foodapplication.databinding.CartCardDesignBinding
import com.simgesengun.foodapplication.entity.CartFood
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.fragment.CartFragmentDirections
import com.simgesengun.foodapplication.viewmodel.CartViewModel


class CartFoodAdapter(var mContext: Context, var cartFoodsList: List<CartFood>, var viewModel: CartViewModel) :
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
        val food = cartFoodsList.get(position)
        holder.design.cartFood = food

        val key = food.id.toString()
        val refCartFoods = viewModel.db.getReference("cart_foods")


        holder.design.imageViewUp.setOnClickListener {
            val updateInfo = HashMap<String,Any>()
            updateInfo["order_number"] = food.order_number!! + 1
            refCartFoods.child(key).updateChildren(updateInfo)
        }
        holder.design.imageViewDown.setOnClickListener {
            if (food.order_number!!>1){
                val updateInfo = HashMap<String,Any>()
                updateInfo["order_number"] = food.order_number!! - 1
                refCartFoods.child(key).updateChildren(updateInfo)
            }
        }

        holder.design.cardView.setOnClickListener {
            val argFood = Food(food.id!!,food.name!!,food.picture_name!!,food.price!!)
            val nav = CartFragmentDirections.toDetails(argFood)
            Navigation.findNavController(it).navigate(nav)
        }

    }

    fun deleteCartItem(pos: Int){
        val food = cartFoodsList.get(pos)
        val newRef = viewModel.db.getReference("cart_foods/" + food.id.toString())

        newRef.removeValue()
        notifyItemRemoved(pos)

    }


    override fun getItemCount(): Int {
        return cartFoodsList.size
    }
}