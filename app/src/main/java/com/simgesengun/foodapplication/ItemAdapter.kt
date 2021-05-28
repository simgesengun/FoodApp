package com.simgesengun.foodapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.foodapplication.databinding.CardDesignBinding

class ItemAdapter (var mContext : Context, var itemList : List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemCardDesignHolder>() {

    inner class ItemCardDesignHolder(itemCardDesignBinding: CardDesignBinding) : RecyclerView.ViewHolder(itemCardDesignBinding.root){
        var design : CardDesignBinding

        init {
            this.design = itemCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater, parent, false)

        return ItemCardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: ItemCardDesignHolder, position: Int) {
        val item = itemList.get(position)

        holder.design.item = item
        holder.design.cardView.setOnClickListener {
            val nav = HomepageFragmentDirections.toDetails(item)
            Navigation.findNavController(it).navigate(nav)
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }
}