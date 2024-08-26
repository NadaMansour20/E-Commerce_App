package com.android.e_commerce_app.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.e_commerce_app.ui.api.ProductsItem


@Dao
interface Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertProductsToDataBase(product:ProductsItem)



    @Query("select * from ProductsItem where favOrNot=1 and foreign_key=:user_id")
     fun getFavProduct(user_id:Int):MutableList<ProductsItem>



    @Query("select * from ProductsItem where addToCart=1 and foreign_key=:user_id ")
     fun getCartProduct(user_id:Int):MutableList<ProductsItem>


    @Insert
     fun insert_User(user:Entity1)

    @Query("select * from user where email =:email limit 1")
    fun getUserByEmail(email: String): Entity1?

    @Delete
    fun delete_cart_fragment(products:List<ProductsItem>)


    @Delete
    fun delet_product(product:ProductsItem)


}
