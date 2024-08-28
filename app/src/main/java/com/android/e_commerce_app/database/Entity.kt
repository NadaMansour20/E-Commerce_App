package com.android.e_commerce_app.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.android.e_commerce_app.ui.api.ProductsItem
import java.io.Serializable


@Entity("user")
data class Entity1(

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val userName:String?=null,

    val email: String? = null,

    val password: String? = null

):Serializable


////relation between 2 table
//data class UserWithProducts(
//    @Embedded val user: Entity1,
//
//    @Relation(
//        parentColumn = "id",
//        entityColumn = "foreign_key"
//    )
//    val products: List<ProductsItem>
//)