package com.android.e_commerce_app.ui.home_fragment
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.ui.api.BuildRetrofit
import kotlinx.coroutines.launch

class HomeFragmentViewModel :BaseViewModel() {


    fun get_productBySearch(query: String) {

        viewModelScope.launch{
            try {

                val result =BuildRetrofit.get_api().get_productBySearch(query)

                if(result.data?.products!=null) {
                    Log.d("HomeFragmentViewModel", "API response: $result")

                    Log.e("Responseeeeeeeeeeeeee","Correcttt")
                    list_liveData.value = result.data?.products
                }
                else{
                    Log.e("Responseeeeeeeeeeeeee","NUlllllllllll")

                }

            }catch (ex:Exception){
                Log.e("Responseeeeeeeeeeeeee",ex.message.toString())


            }

        }
    }

}