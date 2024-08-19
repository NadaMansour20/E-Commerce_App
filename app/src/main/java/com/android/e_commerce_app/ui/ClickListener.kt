package com.android.e_commerce_app.ui

import com.android.e_commerce_app.ui.api.ProductsItem


interface ClickListener {
    fun add_FavClick(position:Int, item: ProductsItem?,flag:Int)
    fun add_Item(item: ProductsItem?,add:Int?)

    fun add_Cart(item: ProductsItem?)

    fun add_minesButton(item: ProductsItem?,add:Int?)

    fun addHolder(position:Int, item: ProductsItem?)

}


interface CategoryClickListener{

    fun categoryClick(position:Int,category_name:String?)
}