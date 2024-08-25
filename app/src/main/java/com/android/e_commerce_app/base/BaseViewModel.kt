package com.android.e_commerce_app.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.ui.api.CategoryResponseItem
import com.android.e_commerce_app.ui.api.ProductsItem

open class BaseViewModel:ViewModel() {



    var progress= MutableLiveData(false)

    var search_item=MutableLiveData<List<ProductsItem?>?>()

    var categorys=MutableLiveData<List<CategoryResponseItem?>?>()

    var all_products=MutableLiveData<List<ProductsItem?>?>()

    var product_by_category=MutableLiveData<List<ProductsItem?>?>()


    var favItems=MutableLiveData<List<ProductsItem?>?>()

    var isEmptyOrNot=MutableLiveData<String>(null)

    var cart_items=MutableLiveData<List<ProductsItem?>?>()

    var flagActivity=MutableLiveData<Boolean>(false)

    var googleFlag=MutableLiveData<Boolean>(false)

    var user_data=MutableLiveData<Entity1>()

    var text=MutableLiveData<String>()


}