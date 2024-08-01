package com.android.e_commerce_app.ui.favfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment

class FavFragment :BaseFragment<FavViewModel,ViewDataBinding>(){
//
//    companion object {
//        fun newInstance() = FavFragment()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




    override fun get_layout(): Int {
        return R.layout.fragment_fav
    }

    override fun get_viewModel(): FavViewModel {
        return ViewModelProvider(this).get(FavViewModel::class.java)
    }


}