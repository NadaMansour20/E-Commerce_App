package com.android.e_commerce_app.ui.home_fragment
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.ui.api.BuildRetrofit
import kotlinx.coroutines.launch

class HomeFragmentViewModel :BaseViewModel() {


    fun get_productBySearch(query: String) {
        progress.value=true

        viewModelScope.launch{
            try {

                val result =BuildRetrofit.get_api().get_productBySearch(query)
                progress.value=false

                if(result.data?.products!=null) {
                    Log.e("HomeFragmentViewModel", "API response: $result")

                    Log.e("Responseeeeeeeeeeeeee","Correcttt")
                    search_item.value = result.data.products
                }
                else{

                    Log.e("Responseeeeeeeeeeeeee","NUlllllllllll")

                }

            }catch (ex:Exception){
                Log.e("Responseeeeeeeeeeeeee",ex.message.toString())
                progress.value=false


            }

        }
    }

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


    fun get_Category(){

        viewModelScope.launch {

            try {

                var result=BuildRetrofit.get_api().get_category()

                if(result.data!=null){

                    categorys.value=result.data

                    Log.e("Categoryssssssssssssss","Correctttttt+${result.data}")
                }
                else{

                    Log.e("Categoryssssssssssssss","Nullllllllll")

                }



            }catch (ex:Exception){

                Log.e("Categoryssssssssssssss",ex.message.toString())

            }
        }
    }

}