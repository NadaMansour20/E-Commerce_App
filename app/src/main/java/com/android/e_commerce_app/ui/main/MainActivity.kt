package com.android.e_commerce_app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityMainBinding
import com.android.e_commerce_app.ui.fragment.HomeFragment
import com.android.e_commerce_app.ui.fragment.LoveFragment
import com.android.final_app.Base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {

    lateinit var button:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.buttonnavigation)

        dataBinding.hvm=viewModel

        button.setOnClickListener{
            if(it.id==R.id.home){
                PushFragmnet(HomeFragment())
            }
            else if(it.id==R.id.search){

            }
            else if(it.id==R.id.profile){

            }
            else if(it.id==R.id.like){
                PushFragmnet(LoveFragment())

            }
            else if(it.id==R.id.cart){

            }
        }

       /* dataBinding.buttonnavigation.setOnClickListener{
            if(it.id==R.id.home){
                PushFragmnet(HomeFragment())
            }
            else if(it.id==R.id.search){

            }
            else if(it.id==R.id.profile){

            }
            else if(it.id==R.id.like){
                PushFragmnet(LoveFragment())

            }
            else if(it.id==R.id.cart){

            }
        }*/


    }

    override fun get_layoutId(): Int {

        return R.layout.activity_main
    }

    override fun get_view_model(): MainViewModel {

        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    fun PushFragmnet(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container_frame,fragment).addToBackStack(null).commit()

    }
}