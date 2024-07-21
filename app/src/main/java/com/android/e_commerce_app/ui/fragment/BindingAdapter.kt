package com.android.e_commerce_app.ui.fragment

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("android:LoadImage")
fun loadImageFromUrl(imageView:ImageView,Url:String){
    Glide.with(imageView)
        .load(Url)
        .into(imageView)

}
