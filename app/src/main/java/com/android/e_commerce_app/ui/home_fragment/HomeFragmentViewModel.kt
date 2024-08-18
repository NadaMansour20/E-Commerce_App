package com.android.e_commerce_app.ui.home_fragment
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.ui.api.BuildRetrofit
import kotlinx.coroutines.launch

class HomeFragmentViewModel :BaseViewModel() {


    fun get_all_product(){

        progress.value=true
        viewModelScope.launch {

            try {

                val result=BuildRetrofit.get_api().get_allProduct()

                if(result.products!=null){
                    progress.value=false

                    all_products.value=result.products


                        Log.e("all product", "Correcttttt API response: ${ result.products}")


                    }

            }catch (ex:Exception){
                progress.value=false

                Log.e("all product",ex.message.toString())


            }


        }

    }

}