package com.simgesengun.foodapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.foodapplication.R
import com.simgesengun.foodapplication.adapter.FoodAdapter
import com.simgesengun.foodapplication.databinding.FragmentHomepageBinding
import com.simgesengun.foodapplication.viewmodel.HomepageViewModel

class HomepageFragment : Fragment() {

    private lateinit var design : FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    private lateinit var adapter : FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)

        (activity as AppCompatActivity).setSupportActionBar(design.toolbar)

        viewModel.foodsList.observe(viewLifecycleOwner,{ foodsList ->
            adapter = FoodAdapter(requireContext(),foodsList)
            design.adapter = adapter
        })

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp : HomepageViewModel by viewModels()
        viewModel = temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Snackbar.make(design.toolbar, "${item.title} clicked", Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoods()
    }

}