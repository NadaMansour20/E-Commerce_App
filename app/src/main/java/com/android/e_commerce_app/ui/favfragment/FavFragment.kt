package com.android.e_commerce_app.ui.favfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.databinding.FragmentFavBinding
import com.android.e_commerce_app.ui.FavClickListener
import com.android.e_commerce_app.ui.api.ProductsItem
import com.android.e_commerce_app.ui.home_fragment.HomeAdapter

class FavFragment :BaseFragment<FavViewModel,FragmentFavBinding>(){
//
//    companion object {
//        fun newInstance() = FavFragment()
//    }


    var favAdapter=HomeAdapter(null)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.ffvm=viewModel


        favAdapter.fav_onclick=object: FavClickListener {
            override fun add_FavClick(position: Int, itemCategory: ProductsItem?) {

                // Toast.makeText(requireContext(), "nadaaaaaaaaaa", Toast.LENGTH_SHORT).show()

            }

        }

    }




    override fun get_layout(): Int {
        return R.layout.fragment_fav
    }

    override fun get_viewModel(): FavViewModel {
        return ViewModelProvider(this).get(FavViewModel::class.java)
    }


}