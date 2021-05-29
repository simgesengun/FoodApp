package com.simgesengun.foodapplication.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:image_resource")
fun setImageResource(imageView: ImageView, image_name: String) {

    val url = "http://kasimadalan.pe.hu/yemekler/resimler/" + image_name

    Picasso.get().load(url).into(imageView)
}

@BindingAdapter("android:set_price")
fun setPrice(textView: TextView, price: Double) {
    textView.text = "$price \u20BA"
}