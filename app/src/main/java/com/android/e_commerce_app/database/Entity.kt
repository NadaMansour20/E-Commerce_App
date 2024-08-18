package com.android.e_commerce_app.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("user")
data class Entity1(

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val email:String,

    val password:String

)
