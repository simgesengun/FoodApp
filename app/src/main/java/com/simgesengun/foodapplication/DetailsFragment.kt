package com.simgesengun.foodapplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.simgesengun.foodapplication.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var design : FragmentDetailsBinding
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        // Bundle
        val bundle : DetailsFragmentArgs by navArgs()
        val item = bundle.item

        design.item = item

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

}