package com.simgesengun.foodapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.firebase.database.*
import com.simgesengun.foodapplication.R
import com.simgesengun.foodapplication.adapter.FoodAdapter
import com.simgesengun.foodapplication.databinding.FragmentDetailsBinding
import com.simgesengun.foodapplication.entity.Food
import com.simgesengun.foodapplication.viewmodel.DetailsViewModel
import com.simgesengun.foodapplication.viewmodel.HomepageViewModel

class DetailsFragment : Fragment() {

    private lateinit var design : FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        // Bundle
        val bundle : DetailsFragmentArgs by navArgs()
        val food = bundle.food

        design.food = food
        design.viewModel = viewModel
        design.detailsFragment = this
        viewModel.number.observe(viewLifecycleOwner,{ number ->
            design.number = number
        })


        return design.root
    }
    fun cartButtonClicked(food : Food){
        viewModel.cartButtonClicked(food)
        val nav = DetailsFragmentDirections.toHomepage()
        Navigation.findNavController(design.button).navigate(nav)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val temp : DetailsViewModel by viewModels()
        viewModel = temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}