package com.android.e_commerce_app.ui.categoryfragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.databinding.FragmentCategoryBinding
import com.android.e_commerce_app.ui.CategoryClickListener
import com.android.e_commerce_app.ui.home_fragment.HomeAdapter

class CategoryFragment :BaseFragment<CategoryViewModel,FragmentCategoryBinding>() {

//    companion object {
//        fun newInstance() = CategoryFragment()
//    }

    var categoryAdapter=CategoryAdapter(null)
    var homeAdapter= HomeAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.civm=viewModel

        observation()

        viewModel.get_Category()

        databinding.categoryTypeRecycler.adapter=categoryAdapter


        categoryAdapter.categoryListener=object : CategoryClickListener {

            override fun categoryClick(position: Int, category_name: String?) {

                viewModel.get_product_by_category(category_name!!)
                databinding.categoryProductrecyclerView.adapter=homeAdapter


            }

        }
    }

    override fun get_layout(): Int {
        return R.layout.fragment_category
    }

    override fun get_viewModel(): CategoryViewModel {
        return ViewModelProvider(this).get(CategoryViewModel::class.java)
    }


    fun observation(){

        viewModel.product_by_category.observe(viewLifecycleOwner, Observer {
            homeAdapter.notify(it)
        })

        viewModel.categorys.observe(viewLifecycleOwner, Observer {category->


            categoryAdapter.notify(category)

        })

        viewModel.progress.observe(viewLifecycleOwner, Observer {

            databinding.categoryProgressbar.isVisible=it
        })
    }


}