package com.android.e_commerce_app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityMainBinding
import com.android.e_commerce_app.ui.cartfragment.CartFragment
import com.android.e_commerce_app.ui.favfragment.FavFragment
import com.android.e_commerce_app.ui.home_fragment.HomeFragment
import com.android.e_commerce_app.ui.profilefragment.ProfileFragment
import com.android.final_app.Base.BaseActivity
import com.google.android.material.navigation.NavigationBarView

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {


    var homeFragment=HomeFragment()
    var favFragment=FavFragment()
    var cartFragment=CartFragment()
    var profileFragment=ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.hvm=viewModel

        PushFragmnet(homeFragment)

        dataBinding.buttonnavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener{

            if(it.itemId==R.id.home){
                PushFragmnet(homeFragment)

            }
            else if(it.itemId==R.id.like){
                PushFragmnet(favFragment)
            }
            else if(it.itemId==R.id.cart){
                PushFragmnet(cartFragment)
            }
            else if(it.itemId==R.id.profile){
                PushFragmnet(profileFragment)
            }

            return@OnItemSelectedListener true

        })




    }

    override fun get_layoutId(): Int {

        return R.layout.activity_main
    }

    override fun get_view_model(): MainViewModel {

        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    fun PushFragmnet(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container_frame,fragment).commit()

    }
}