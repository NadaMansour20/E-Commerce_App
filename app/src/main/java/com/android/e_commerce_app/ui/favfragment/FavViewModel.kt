package com.android.e_commerce_app.ui.favfragment

import androidx.lifecycle.viewModelScope
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.MyDataBase
import kotlinx.coroutines.launch

class FavViewModel :BaseViewModel(){



    fun getFavProducts(){

        viewModelScope.launch {

            try {
                val result=MyDataBase.getDataBase().productDao().getFavProduct(true)

                favItems.value=result

            }catch (ex:Exception){

                throw ex
            }
        }
    }




}