package com.simgesengun.foodapplication

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.foodapplication.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment() {

    private lateinit var itemsList : ArrayList<Item>
    private lateinit var adapter : ItemAdapter
    private lateinit var design : FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)

        itemsList = createItemsList()

        (activity as AppCompatActivity).setSupportActionBar(design.toolbar)

        adapter = ItemAdapter(requireContext(),itemsList)
        design.itemAdapter = adapter

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Snackbar.make(design.toolbar, "${item.title} clicked", Snackbar.LENGTH_SHORT).show()
        return true
    }

    fun createItemsList() : ArrayList<Item>{
        return arrayListOf(
            Item(0,"Ayran",20.5,"ayran"),
            Item(1,"Baklava",20.5,"baklava"),
            Item(2,"Pizza",20.5,"pizza"),
                    Item(3,"Ayran",20.5,"ayran"),
        Item(4,"Baklava",20.5,"baklava"),
        Item(5,"Pizza",20.5,"pizza")
        )
    }

}