package com.android.e_commerce_app.ui.cartfragment

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.ui.api.ProductsItem
import kotlinx.coroutines.launch

class CartViewModel :BaseViewModel(){


    fun getCartProducts(useId:Int){

        viewModelScope.launch {

            try {
                var result= MyDataBase.getDataBase().productDao().getCartProduct(useId)

                Log.e("getCartProduct","Correcttttttt${result}")

                //all price of products in card
                var sum=0.0
                for(i in 0..<result.size){
                    sum+= result[i].price!! * result[i].addNumber

                    if(result[i].addNumber==0){
                        val product=ProductsItem(result[i].favOrNot,0,false,result[i].thumbnail
                        ,result[i].rating,result[i].description,result[i].title,result[i].price,result[i].id,result[i].stock,result[i].foreign_key)

                        MyDataBase.getDataBase().productDao().insertProductsToDataBase(product)

                         result= MyDataBase.getDataBase().productDao().getCartProduct(useId)


                        Log.e("leave CartProduct","leaveeeeeeeeeee${product}")

                    }

                }

                text.value=String.format("%.2f", sum)

                cart_items.value=result

            }catch (ex:Exception){

                throw ex
            }
        }
    }
}