package com.android.e_commerce_app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.e_commerce_app.ui.api.ProductsItem


@Database(entities=[Entity1::class,ProductsItem::class],version=32)
abstract class MyDataBase:RoomDatabase(){



    abstract fun productDao():Dao   //polymorphism

    companion object{

        private val DataBaseName="Data_Base"
        private var schima:MyDataBase?=null


        fun getInstance(context: Context){

            if (schima==null){

                schima=Room.databaseBuilder(

                    context.applicationContext,
                    MyDataBase::class.java,
                    DataBaseName
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
        }

        fun getDataBase():MyDataBase{
            return schima!!
        }


    }


}