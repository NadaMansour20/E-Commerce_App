package com.android.e_commerce_app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityMainBinding
import com.android.e_commerce_app.ui.fragment.HomeCategoryAdapter
import com.android.e_commerce_app.ui.fragment.HomeFragment
import com.android.final_app.Base.BaseActivity
import com.google.android.material.navigation.NavigationBarView

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {

     var adapter:HomeCategoryAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.hvm=viewModel

        dataBinding.buttonnavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener{

            if(it.itemId==R.id.home){
                PushFragmnet(HomeFragment())

            }
            return@OnItemSelectedListener true

        })

//        adapter?.fav_onclick=object:ClickListener{
//            override fun add_FavClick(position: Int,itemCategory: Item_Category) {
//                Toast.makeText(this@MainActivity, "nadaaaaaaaaaa", Toast.LENGTH_SHORT).show()
//            }
//
//        }


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