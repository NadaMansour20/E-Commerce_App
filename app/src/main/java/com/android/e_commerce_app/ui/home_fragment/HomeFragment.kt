package com.android.e_commerce_app.ui.home_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.FragmentHomeBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem

class HomeFragment :BaseFragment<HomeFragmentViewModel,FragmentHomeBinding>(){

//    companion object {
//        fun newInstance() = HomeFragment()
//    }

    //var itemList:MutableList<Item_Category>?=null

    var homeAdapter=HomeCategoryAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.fvm=viewModel


        //fetch data from api
       // viewModel.get_productBySearch("   Women")

        viewModel.get_best_Seller(   "BEST_SELLERS","software")

        createList()


        databinding.recyclerView1.adapter=homeAdapter
        databinding.recyclerView2.adapter=homeAdapter
        databinding.recyclerView3.adapter=homeAdapter


        homeAdapter.fav_onclick=object: ClickListener {
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

        //observe data to activity
//        viewModel.product_list_liveData.observe(viewLifecycleOwner, Observer {
//
//            homeAdapter.notify(it)
//
//
//        })
        viewModel.bestseller_list_liveData.observe(viewLifecycleOwner, Observer {

            homeAdapter.notify(it)
        })
    }





}