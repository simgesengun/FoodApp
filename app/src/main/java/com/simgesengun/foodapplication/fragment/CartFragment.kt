package com.simgesengun.foodapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import com.simgesengun.foodapplication.R
import com.simgesengun.foodapplication.adapter.CartFoodAdapter
import com.simgesengun.foodapplication.adapter.FoodAdapter
import com.simgesengun.foodapplication.databinding.FragmentCartBinding
import com.simgesengun.foodapplication.databinding.FragmentHomepageBinding
import com.simgesengun.foodapplication.entity.SwipeToDelete
import com.simgesengun.foodapplication.viewmodel.CartViewModel
import com.simgesengun.foodapplication.viewmodel.HomepageViewModel

class CartFragment : Fragment() {

    private lateinit var design : FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    private lateinit var adapter : CartFoodAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        (activity as AppCompatActivity).setSupportActionBar(design.toolbar)

        viewModel.cartFoodsList.observe(viewLifecycleOwner,{ cartFoodsList ->
            adapter = CartFoodAdapter(requireContext(),cartFoodsList,viewModel)
            design.adapter = adapter
            ItemTouchHelper(SwipeToDelete(adapter)).attachToRecyclerView(design.recyclerView)

        })
        viewModel.totalPrice.observe(viewLifecycleOwner,{ totalPrice ->
            design.totalPrice = totalPrice
        })





        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp : CartViewModel by viewModels()
        viewModel = temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}