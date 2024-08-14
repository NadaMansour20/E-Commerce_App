package com.android.e_commerce_app.ui.home_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.FragmentHomeBinding
import com.android.e_commerce_app.ui.CategoryClickListener
import com.android.e_commerce_app.ui.FavClickListener
import com.android.e_commerce_app.ui.api.ProductsItem


class HomeFragment :BaseFragment<HomeFragmentViewModel,FragmentHomeBinding>(){

//    companion object {
//        fun newInstance() = HomeFragment()
//    }

    //var itemList:MutableList<Category>?=null


    var homeAdapter=HomeAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.fvm=viewModel


        viewModel.get_all_product()

        createList()


        databinding.recyclerView1.adapter=homeAdapter



        homeAdapter.fav_onclick=object: FavClickListener {
            override fun add_FavClick(position: Int, itemCategory: ProductsItem?) {

               // Toast.makeText(requireContext(), "nadaaaaaaaaaa", Toast.LENGTH_SHORT).show()

            }

        }




    }

    override fun get_layout(): Int {
        return R.layout.fragment_home
    }

    override fun get_viewModel(): HomeFragmentViewModel {
        return ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }
    fun createList() {


        viewModel.all_products.observe(viewLifecycleOwner, Observer {
            homeAdapter.notify(it)
        })


        viewModel.progress.observe(viewLifecycleOwner, Observer {

            databinding.homeProgressbar.isVisible=it
        })

    }





}