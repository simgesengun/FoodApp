package com.simgesengun.foodapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.foodapplication.R
import com.simgesengun.foodapplication.databinding.CardDesignBinding
import com.simgesengun.foodapplication.databinding.HomepageHeaderBinding
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.fragment.HomepageFragmentDirections
import com.simgesengun.foodapplication.viewmodel.HomepageViewModel

class FoodAdapter (var mContext : Context, var foodsList : List<Food>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1

    inner class HeaderHolder(val binding : HomepageHeaderBinding) : RecyclerView.ViewHolder(binding.root)
    inner class BodyHolder(val binding : CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        return when(viewType){
            TYPE_HEADER -> HeaderHolder(HomepageHeaderBinding.inflate(layoutInflater, parent, false))
            else -> BodyHolder(CardDesignBinding.inflate(layoutInflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == TYPE_HEADER){
            val header : HeaderHolder = holder as HeaderHolder
            when (position){
                0 -> header.binding.text = mContext.getString(R.string.title)
                1 -> header.binding.text = "\n"

            }
            return
        }
        val food = foodsList.get(position-2)

        val body : BodyHolder = holder as BodyHolder
        body.binding.food = food

        body.binding.cardView.setOnClickListener {
            val nav = HomepageFragmentDirections.toDetails(food)
            Navigation.findNavController(it).navigate(nav)
        }
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0,1 -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }
}