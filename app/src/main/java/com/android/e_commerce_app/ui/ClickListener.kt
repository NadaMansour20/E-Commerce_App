package com.android.e_commerce_app.ui

import com.android.e_commerce_app.ui.api.ProductsItem


interface FavClickListener {
    fun add_FavClick(position:Int, item: ProductsItem?)

}

interface CategoryClickListener{

    fun categoryClick(position:Int,category_name:String?)
}