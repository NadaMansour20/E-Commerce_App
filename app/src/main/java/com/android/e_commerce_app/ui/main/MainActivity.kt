package com.android.e_commerce_app.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.databinding.ActivityMainBinding
import com.android.e_commerce_app.ui.cartfragment.CartFragment
import com.android.e_commerce_app.ui.categoryfragment.CategoryFragment
import com.android.e_commerce_app.ui.favfragment.FavFragment
import com.android.e_commerce_app.ui.home_fragment.HomeFragment
import com.android.e_commerce_app.ui.searchfragment.SearchFragment
import com.android.final_app.Base.BaseActivity
import com.google.android.material.navigation.NavigationBarView

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {


    var homeFragment=HomeFragment()
    var favFragment=FavFragment()
    var cartFragment=CartFragment()
    var searchFragment=SearchFragment()
    var categoryFragment=CategoryFragment()

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
            else if(it.itemId==R.id.search){
                PushFragmnet(searchFragment)
            }
            else if(it.itemId==R.id.category){
                PushFragmnet(categoryFragment)
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

        val user = intent.getSerializableExtra("user") as Entity1

        Log.e("Loginnnnnnnnnnnnnnnnnnnn","$user")

        if(user!=null) {

            val bundle = Bundle().apply {
                putSerializable("user_object", user)
            }
            fragment.arguments = bundle
        }

        supportFragmentManager.beginTransaction().replace(R.id.container_frame,fragment).commit()

    }

}