package com.android.e_commerce_app.ui.api

import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {


    @GET("v2/product-details")
    fun get_allProduct(

        @Query("asin")
        asin:String,

        @Query("apihub_key")
        apihub_key: String =Constant.apihub_key,
        @Query("apihub_host")
        apihub_host:String=Constant.apihub_host,
        @Query("apihub_endpoint")
        apihub_endpoint:String=Constant.apihub_endpoint

    ):ProductResponse

    @GET("v2/search")
    fun get_productBySearch(

        @Query("query")
        query:String,

        @Query("apihub_key")
        apihub_key: String =Constant.apihub_key,
        @Query("apihub_host")
        apihub_host:String=Constant.apihub_host,
        @Query("apihub_endpoint")
        apihub_endpoint:String=Constant.apihub_endpoint
    ):ProductResponse


    @GET("v2/best-sellers")
    fun get_bestSellerApi(

        @Query("type")
        type:String,
        @Query("category")
        category:String,

        @Query("apihub_key")
        apihub_key: String =Constant.apihub_key,
        @Query("apihub_host")
        apihub_host:String=Constant.apihub_host,
        @Query("apihub_endpoint")
        apihub_endpoint:String=Constant.apihub_endpoint


        ):ProductResponse

    @GET("v2/products-by-category")
    fun get_products_byCategory(

        @Query("category_id")
        categoryId:String,

        @Query("apihub_key")
        apihub_key: String =Constant.apihub_key,
        @Query("apihub_host")
        apihub_host:String=Constant.apihub_host,
        @Query("apihub_endpoint")
        apihub_endpoint:String=Constant.apihub_endpoint

    ):ProductResponse

}