package com.simgesengun.foodapplication

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:image_resource")
fun setImageResource(imageView: ImageView, image_name: String) {
    val id = imageView.context.resources.getIdentifier(image_name,"drawable",imageView.context.packageName)
    imageView.setImageResource(id)
}

@BindingAdapter("android:set_price")
fun setPrice(textView: TextView, price: Double) {
    textView.text = "$price \u20BA"
}