package com.android.e_commerce_app.model



data class User(

    var id:String?=null,
    var email:String?=null,
    var pass:String?=null

){
    companion object{

        const val collectionName="user"
    }
}