package com.android.e_commerce_app.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.e_commerce_app.ui.api.ProductsItem

open class BaseViewModel:ViewModel() {


    var product_list_liveData= MutableLiveData<List<ProductsItem?>?>()
    var bestseller_list_liveData= MutableLiveData<List<ProductsItem?>?>()

}