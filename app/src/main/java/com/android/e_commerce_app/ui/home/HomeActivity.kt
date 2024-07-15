package com.android.e_commerce_app.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityHomeBinding
import com.android.final_app.Base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel,ActivityHomeBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.hvm=viewModel
    }

    override fun get_layoutId(): Int {

        return R.layout.activity_home
    }

    override fun get_view_model(): HomeViewModel {

        return ViewModelProvider(this).get(HomeViewModel::class.java)
    }
}