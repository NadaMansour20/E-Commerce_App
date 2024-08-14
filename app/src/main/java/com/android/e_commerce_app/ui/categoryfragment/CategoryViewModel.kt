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

                var result= BuildRetrofit.get_api().get_category()

                if(result!=null){
                    categorys.value=result

                    Log.e("Categoryssssssssssssss","Correctttttt${result}")
                }
                else{

                    Log.e("Categoryssssssssssssss","Nullllllllll")

                }


            }catch (ex:Exception){

                Log.e("Categoryssssssssssssss",ex.message.toString())

            }
        }
    }

    fun get_product_by_category(category_id:String){

        progress.value=true

        viewModelScope.launch {

            try {

                val result= BuildRetrofit.get_api().get_products_byCategory(category_id)

                if(result.products!=null){
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