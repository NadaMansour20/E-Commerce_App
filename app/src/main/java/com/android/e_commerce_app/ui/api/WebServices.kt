package com.android.e_commerce_app.ui.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WebServices {

//    @GET("v2/product-details")
//    @Headers(
//        "x-apihub-key: VywaucojckLdp-cXDx4eu4OHfAgdUvSUywiaK-osNYXIF3CcN-",
//        "x-apihub-host: Real-Time-Amazon-Data.allthingsdev.co",
//        "x-apihub-endpoint: d6976176-ade6-4034-98d7-c3fda4e68bfb"
//    )
//    suspend fun get_allProduct(
//
//        @Query("asin")
//        asin:String,
//
//    ):ProductResponse
//
    @GET("v2/search")
    @Headers(
        "x-apihub-key: VywaucojckLdp-cXDx4eu4OHfAgdUvSUywiaK-osNYXIF3CcN-",
        "x-apihub-host: Real-Time-Amazon-Data.allthingsdev.co",
        "x-apihub-endpoint: d6976176-ade6-4034-98d7-c3fda4e68bfb"
    )
   suspend fun get_productBySearch(

        @Query("query")
        query:String,

    ):ProductResponse


    @GET("v2/best-sellers")
    @Headers(
        "x-apihub-key: VywaucojckLdp-cXDx4eu4OHfAgdUvSUywiaK-osNYXIF3CcN-",
        "x-apihub-host: Real-Time-Amazon-Data.allthingsdev.co",
        "x-apihub-endpoint: d6976176-ade6-4034-98d7-c3fda4e68bfb"
    )
    suspend fun get_bestSellerApi(

        @Query("type")
        type:String=Constant.bestseller,
        @Query("category")
        category:String,

        ):ProductResponse

//    @GET("v2/products-by-category")
//    @Headers(
//        "x-apihub-key: VywaucojckLdp-cXDx4eu4OHfAgdUvSUywiaK-osNYXIF3CcN-",
//        "x-apihub-host: Real-Time-Amazon-Data.allthingsdev.co",
//        "x-apihub-endpoint: d6976176-ade6-4034-98d7-c3fda4e68bfb"
//    )
//    suspend fun get_products_byCategory(
//
//        @Query("category_id")
//        categoryId:String,
//
//
//    ):ProductResponse


    @GET("v2/product-category-list")
    @Headers(
        "x-apihub-key: VywaucojckLdp-cXDx4eu4OHfAgdUvSUywiaK-osNYXIF3CcN-",
        "x-apihub-host: Real-Time-Amazon-Data.allthingsdev.co",
        "x-apihub-endpoint: d6976176-ade6-4034-98d7-c3fda4e68bfb"
    )
    suspend fun get_category(

    ):CategoryResponse



    @GET("v2/product-offers")
    @Headers(
        "x-apihub-key: VywaucojckLdp-cXDx4eu4OHfAgdUvSUywiaK-osNYXIF3CcN-",
        "x-apihub-host: Real-Time-Amazon-Data.allthingsdev.co",
        "x-apihub-endpoint: d6976176-ade6-4034-98d7-c3fda4e68bfb"
    )
    suspend fun get_offers(

        asins:String?=null
    ):Data

}