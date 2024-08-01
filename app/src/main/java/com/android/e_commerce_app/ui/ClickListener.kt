package com.android.e_commerce_app.ui

import com.android.e_commerce_app.ui.api.ProductsItem


interface ClickListener {
    fun add_FavClick(position:Int, item: ProductsItem?)

}