package com.android.e_commerce_app.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.FragmentHomeBinding

class HomeFragment :BaseFragment<HomeFragmentViewModel>(){

//    companion object {
//        fun newInstance() = HomeFragment()
//    }

    lateinit var DataBinding:FragmentHomeBinding
    var homeAdapter=HomeCategoryAdapter(null)
    lateinit var itemList:MutableList<Item_Category>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         DataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return DataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createList()
        homeAdapter.items=itemList

        DataBinding.recyclerView1.adapter=homeAdapter


    }



    override fun get_layout(): Int {
        return R.layout.fragment_home
    }

    override fun get_viewModel(): HomeFragmentViewModel {
        return ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }
    fun createList(){
        itemList.add(Item_Category(R.drawable.image,"cccc",2000))
    }


}