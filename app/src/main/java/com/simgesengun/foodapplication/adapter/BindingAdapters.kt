package com.simgesengun.foodapplication.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.simgesengun.foodapplication.R
import com.squareup.picasso.Picasso

@BindingAdapter("android:image_resource")
fun setImageResource(imageView: ImageView, image_name: String) {

    val url = "http://kasimadalan.pe.hu/yemekler/resimler/" + image_name

    Picasso.get().load(url).into(imageView)
}

@BindingAdapter("android:set_price")
fun setPrice(textView: TextView, price: Int) {
    textView.text = "$price \u20BA"
}
@BindingAdapter("android:set_title")
fun setTitle(textView: TextView, item_count: Int) {
    if(item_count>0){
        textView.text = "Your tasty meal!"
        textView.setCompoundDrawables(null,null,null,null)
    }else{
        textView.text = "Your cart is empty "
        val drawable : Drawable? = textView.context.getDrawable(R.drawable.ic_sad)
        textView.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)
    }
}