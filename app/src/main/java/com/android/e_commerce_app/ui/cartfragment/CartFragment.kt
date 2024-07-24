package com.android.e_commerce_app.ui.cartfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.databinding.FragmentCartBinding

class CartFragment : BaseFragment<CartViewModel,FragmentCartBinding>() {

//    companion object {
//        fun newInstance() = CartFragment()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.cvm=viewModel

    }


    override fun get_layout(): Int {
        return R.layout.fragment_cart
    }

    override fun get_viewModel(): CartViewModel {
        return ViewModelProvider(this).get(CartViewModel::class.java)
    }



}