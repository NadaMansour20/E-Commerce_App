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
                var resultt= MyDataBase.getDataBase().productDao().getCartProduct(useId)

                Log.e("getCartProduct","Correcttttttt${resultt}")


                //all price of products in card
                var sum=0.0
                for (result in resultt) {
                    sum += result.price!! * result.addNumber

                    if (result.addNumber == 0) {
                        val product = ProductsItem(
                            result.favOrNot,
                            0,
                            false,
                            result.thumbnail,
                            result.rating,
                            result.description,
                            result.title,
                            result.price,
                            result.id,
                            result.stock,
                            result.foreign_key
                        )

                        MyDataBase.getDataBase().productDao().delet_product(product)

                        resultt = MyDataBase.getDataBase().productDao().getCartProduct(useId)


                        Log.e("leave CartProduct", "leaveeeeeeeeeee${result}")

                    }
                }


                text.value=String.format("%.2f", sum)

                cart_items.value=resultt

            }catch (ex:Exception){

                throw ex
            }
        }
    }
}