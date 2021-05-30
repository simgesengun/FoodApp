package com.simgesengun.foodapplication.entity

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.foodapplication.adapter.CartFoodAdapter
import com.simgesengun.foodapplication.viewmodel.CartViewModel

class SwipeToDelete(var adapter : CartFoodAdapter) : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        adapter.deleteCartItem(pos)

    }

}