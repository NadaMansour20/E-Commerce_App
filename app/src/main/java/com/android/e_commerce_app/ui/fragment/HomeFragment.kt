package com.android.e_commerce_app.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.FragmentHomeBinding

class HomeFragment :BaseFragment<HomeFragmentViewModel,FragmentHomeBinding>(){

//    companion object {
//        fun newInstance() = HomeFragment()
//    }

    var itemList:MutableList<Item_Category>?=null

    var homeAdapter=HomeCategoryAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.fvm=viewModel



        createList()
        homeAdapter.items=itemList

        databinding.recyclerView1.adapter=homeAdapter
        databinding.recyclerView2.adapter=homeAdapter
        databinding.recyclerView3.adapter=homeAdapter




    }



    override fun get_layout(): Int {
        return R.layout.fragment_home
    }

    override fun get_viewModel(): HomeFragmentViewModel {
        return ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }
    fun createList() {
        itemList= arrayListOf() //مهم

        for (i in 0..10) {
            itemList?.add(Item_Category(R.drawable.image, "cccc", 3000))
        }
        homeAdapter.notify(itemList)

    }


}