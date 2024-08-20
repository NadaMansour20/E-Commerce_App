package com.android.e_commerce_app.ui.cartfragment

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.MyDataBase
import kotlinx.coroutines.launch

class CartViewModel :BaseViewModel(){


    fun getCartProducts(useId:Int){

        viewModelScope.launch {

            try {
                val result= MyDataBase.getDataBase().productDao().getCartProduct(useId)

                Log.e("getCartProduct","Correcttttttt${result}")

                cart_items.value=result

            }catch (ex:Exception){

                throw ex
            }
        }
    }}