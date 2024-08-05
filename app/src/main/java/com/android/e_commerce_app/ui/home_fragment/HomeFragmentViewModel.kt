package com.android.e_commerce_app.ui.home_fragment
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.ui.api.BuildRetrofit
import kotlinx.coroutines.launch

class HomeFragmentViewModel :BaseViewModel() {


//    fun get_productBySearch(query: String) {
//
//        viewModelScope.launch{
//            try {
//
//                val result =BuildRetrofit.get_api().get_productBySearch(query)
//
//                if(result.data?.products!=null) {
//                    Log.e("HomeFragmentViewModel", "API response: $result")
//
//                    Log.e("Responseeeeeeeeeeeeee","Correcttt")
//                    product_list_liveData.value = result.data.products
//                }
//                else{
//                    Log.e("Responseeeeeeeeeeeeee","NUlllllllllll")
//
//                }
//
//            }catch (ex:Exception){
//                Log.e("Responseeeeeeeeeeeeee",ex.message.toString())
//
//
//            }
//
//        }
//    }

    fun get_best_Seller(type:String,category:String){


        viewModelScope.launch {

            try {

                val result=BuildRetrofit.get_api().get_bestSellerApi(type,category)

                for(i in 0..result.data?.products!!.size) {

                    if (result.data.products.get(i)?.isBestSeller == true) {

                        bestseller_list_liveData.value = listOf(result.data.products.get(i))

                        Log.e("Besttttttttt seller","Correcttt")

                        Log.e("Best sellerrrrr", "API response: ${ result.data.products.get(i)}")


                    }
                }

            }catch (ex:Exception){

                Log.e("Besttttttttt seller",ex.message.toString())


            }


        }

    }

}