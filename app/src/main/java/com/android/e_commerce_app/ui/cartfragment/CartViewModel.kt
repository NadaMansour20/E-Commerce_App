package com.android.e_commerce_app.ui.cartfragment

import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.MyDataBase
import kotlinx.coroutines.launch

class CartViewModel :BaseViewModel(){


    fun getCartProducts(){

        viewModelScope.launch {

            try {
                val result= MyDataBase.getDataBase().productDao().getCartProduct(true)

                cart_items.value=result

            }catch (ex:Exception){

                throw ex
            }
        }
    }}