package com.android.e_commerce_app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragment<VM:BaseViewModel,DB:ViewDataBinding>:Fragment() {

    lateinit var viewModel:VM
    lateinit var databinding:DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        databinding=DataBindingUtil.inflate(inflater,get_layout(),container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=get_viewModel()
    }

    abstract fun get_layout():Int

   abstract fun get_viewModel():VM


}