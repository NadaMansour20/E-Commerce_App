package com.android.e_commerce_app.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.e_commerce_app.ui.api.DataItem
import com.android.e_commerce_app.ui.api.ProductsItem

open class BaseViewModel:ViewModel() {


    var bestseller_list_liveData= MutableLiveData<List<ProductsItem?>?>()

    var progress= MutableLiveData(false)

    var search_item=MutableLiveData<List<ProductsItem?>?>()

    var categorys=MutableLiveData<List<DataItem?>?>()

}