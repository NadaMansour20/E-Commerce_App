package com.android.e_commerce_app.ui.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuildRetrofit {

    companion object{

        private var retrofit:Retrofit?=null

        private fun build_retrofit():Retrofit{

            if(retrofit==null){

                retrofit= Retrofit.Builder().baseUrl(Constant.base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }

            return retrofit!!

        }

        fun get_api():WebServices{

            return build_retrofit().create(WebServices::class.java)
        }



    }
}