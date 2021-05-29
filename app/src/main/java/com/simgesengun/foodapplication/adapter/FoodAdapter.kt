package com.simgesengun.foodapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.foodapplication.databinding.CardDesignBinding
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.fragment.HomepageFragmentDirections
import com.simgesengun.foodapplication.viewmodel.HomepageViewModel

class FoodAdapter (var mContext : Context, var foodsList : List<Food>,  var viewModel : HomepageViewModel) :
    RecyclerView.Adapter<FoodAdapter.FoodCardDesignHolder>() {

    inner class FoodCardDesignHolder(itemCardDesignBinding: CardDesignBinding) : RecyclerView.ViewHolder(itemCardDesignBinding.root){
        var design : CardDesignBinding

        init {
            this.design = itemCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater, parent, false)

        return FoodCardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: FoodCardDesignHolder, position: Int) {
        val food = foodsList.get(position)
        holder.design.food = food

        holder.design.cardView.setOnClickListener {
            val nav = HomepageFragmentDirections.toDetails(food)
            Navigation.findNavController(it).navigate(nav)
        }
    }


    override fun getItemCount(): Int {
        return foodsList.size
    }
}