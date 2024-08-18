package com.android.e_commerce_app.ui.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {

    @GET("products")

    suspend fun get_allProduct(

        @Query("limit")
        limit:Int=194,
        @Query("order")
        order: String ="asc",
        @Query("sortBy")
        sortBy: String ="title"

    ):ProductResponse
    @GET("products/search")
   suspend fun get_productBySearch(

        @Query("q")
        q:String,

    ):ProductResponse

    @GET("products/category/{categoryName}")
    suspend fun get_products_byCategory(

        @Path("categoryName")
        categoryName: String


    ):ProductResponse

    @GET("products/categories")
    suspend fun get_category(

    ):List<CategoryResponseItem>


}