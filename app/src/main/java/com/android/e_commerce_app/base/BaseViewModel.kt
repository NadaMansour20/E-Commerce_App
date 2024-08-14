package com.android.e_commerce_app.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.e_commerce_app.ui.api.CategoryResponse
import com.android.e_commerce_app.ui.api.CategoryResponseItem
import com.android.e_commerce_app.ui.api.ProductsItem

open class BaseViewModel:ViewModel() {



    var progress= MutableLiveData(false)

    var search_item=MutableLiveData<List<ProductsItem?>?>()

    var categorys=MutableLiveData<List<CategoryResponseItem?>?>()

    var all_products=MutableLiveData<List<ProductsItem?>?>()

    var product_by_category=MutableLiveData<List<ProductsItem?>?>()

}