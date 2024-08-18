package com.android.e_commerce_app

import android.app.Application
import com.android.e_commerce_app.database.MyDataBase
import com.google.firebase.FirebaseApp

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        MyDataBase.getInstance(this)
    }
}