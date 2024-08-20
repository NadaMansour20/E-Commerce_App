package com.android.e_commerce_app.ui.favfragment

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.MyDataBase
import kotlinx.coroutines.launch

class FavViewModel :BaseViewModel(){



    fun getFavProducts(userId:Int){

        viewModelScope.launch {

            try {
                val result=MyDataBase.getDataBase().productDao().getFavProduct(userId)

                Log.e("getCartProduct","Correcttttttt${result}")


                favItems.value=result

            }catch (ex:Exception){

                throw ex
            }
        }
    }




}