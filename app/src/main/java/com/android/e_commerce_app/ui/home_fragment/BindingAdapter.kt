package com.android.e_commerce_app.ui.home_fragment

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("android:LoadImage")
fun loadImageFromUrl(imageView:ImageView,Url:String){
    Glide.with(imageView)
        .load(Url)
        .into(imageView)

}

@BindingAdapter("android:error")
fun error(textInputLayout: TextInputLayout,error:String?)
{
    textInputLayout.error=error
}
