package com.android.e_commerce_app.ui.searchfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.ui.api.BuildRetrofit
import kotlinx.coroutines.launch

class SearchViewModel :BaseViewModel() {



    fun get_productBySearch(query: String) {
        progress.value=true

        viewModelScope.launch{
            try {

                val result = BuildRetrofit.get_api().get_productBySearch(query)
                progress.value=false

                if(result.products!=null) {
                    Log.e("Searchhhhhhhh", "API response: $result")

                    Log.e("Responseeeeeeeeeeeeee","Correcttt")
                    search_item.value = result.products
                }
                else{

                    Log.e("Responseeeeeeeeeeeeee","NUlllllllllll")

                }

            }catch (ex:Exception){
                Log.e("Responseeeeeeeeeeeeee",ex.message.toString())
                progress.value=false


            }

        }
    }}