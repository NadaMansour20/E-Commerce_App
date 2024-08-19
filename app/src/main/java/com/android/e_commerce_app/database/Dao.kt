package com.android.e_commerce_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.android.e_commerce_app.ui.api.ProductsItem


@Dao
interface Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductsToDataBase(product:ProductsItem)

    @Query("select * from ProductsItem where id=:ProductId")
    fun getProduct(ProductId:Int):MutableList<ProductsItem>


    @Query("select * from ProductsItem where favOrNot=1 & foreign_key=:user_id")
    fun getFavProduct(user_id:Int):MutableList<ProductsItem>



    @Query("select * from ProductsItem where addToCart=1 & foreign_key=:user_id ")
    fun getCartProduct(user_id:Int):MutableList<ProductsItem>

    @Transaction
    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserWithProducts(userId: Int): UserWithProducts


    @Insert
    fun insert_User(user:Entity1)

}
