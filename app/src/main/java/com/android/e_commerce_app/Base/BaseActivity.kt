package com.android.final_app.Base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.android.e_commerce_app.Base.BaseViewModel

abstract class BaseActivity<VM:BaseViewModel,DB:ViewDataBinding>:AppCompatActivity() {

    lateinit var viewModel:VM
    lateinit var dataBinding:DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //initial viewModel and dataBinding
        dataBinding=DataBindingUtil.setContentView(this,get_layoutId())

        viewModel=get_view_model()





    }


    abstract fun get_layoutId():Int

    abstract fun get_view_model():VM


}