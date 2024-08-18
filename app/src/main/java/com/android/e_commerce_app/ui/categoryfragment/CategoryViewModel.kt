package com.android.e_commerce_app.ui.categoryfragment

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.ui.api.BuildRetrofit
import kotlinx.coroutines.launch

class CategoryViewModel :BaseViewModel() {


    fun get_Category(){

        viewModelScope.launch {

            try {

                val result= BuildRetrofit.get_api().get_category()

                categorys.value=result

                Log.e("Categoryssssssssssssss","Correctttttt${result}")


            }catch (ex:Exception){

                Log.e("Categoryssssssssssssss",ex.message.toString())

            }
        }
    }

    fun get_product_by_category(category_name:String){

        progress.value=true

        viewModelScope.launch {

            try {

                val result= BuildRetrofit.get_api().get_products_byCategory(category_name)

                if(result.products.isNullOrEmpty()){

                    isEmptyOrNot.value=category_name
                    Log.e("Product By Categoryyyyyyyyyy","Emptyyyyyy")


                }
                else{

                    progress.value=false

                    product_by_category.value=result.products

                    Log.e("Product By Categoryyyyyyyyyy","Correct+${result.products}")

                }


            }catch (ex:Exception){

                progress.value=false
                Log.e("Product By Categoryyyyyyyyyy","errorrrrrrrrrrrr")


            }
        }

    }
}