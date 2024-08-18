package com.android.e_commerce_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.e_commerce_app.ui.api.ProductsItem


@Dao
interface Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductsToDataBase(product:ProductsItem)

    @Query("select * from ProductsItem where id=:ProductId")
    fun getProduct(ProductId:Int):MutableList<ProductsItem>


    @Query("select * from ProductsItem where favOrNot=:fav")
    fun getFavProduct(fav:Boolean):MutableList<ProductsItem>



    @Query("select * from ProductsItem where addToCart=:add_to_cart")
    fun getCartProduct(add_to_cart:Boolean):MutableList<ProductsItem>
}