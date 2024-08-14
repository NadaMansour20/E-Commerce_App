package com.android.e_commerce_app.ui.searchfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.databinding.FragmentSearchBinding
import com.android.e_commerce_app.ui.FavClickListener
import com.android.e_commerce_app.ui.api.ProductsItem
import com.android.e_commerce_app.ui.home_fragment.HomeAdapter

class SearchFragment :BaseFragment<SearchViewModel,FragmentSearchBinding>() {

//    companion object {
//        fun newInstance() = SearchFragment()
//    }

    var searchAdapter=HomeAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.svm=viewModel

        animation()
        data_observation()


        databinding.searchRecyclerView.adapter=searchAdapter


        // the action that taken when click on search_view
        databinding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                //fetch data from api
                viewModel.get_productBySearch(query!!)
                return true


            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false

            }

        })

        searchAdapter.fav_onclick=object: FavClickListener {
            override fun add_FavClick(position: Int, itemCategory: ProductsItem?) {

                // Toast.makeText(requireContext(), "nadaaaaaaaaaa", Toast.LENGTH_SHORT).show()

            }

        }
    }


    override fun get_layout(): Int {
        return R.layout.fragment_search
    }

    override fun get_viewModel(): SearchViewModel {

        return ViewModelProvider(this).get(SearchViewModel::class.java)
    }


    var data_recieved=false
    fun data_observation(){

        //observe data to activity

        viewModel.search_item.observe(viewLifecycleOwner, Observer{

           searchAdapter.notify(it)

            databinding.animationImg.isVisible=false

            data_recieved=true

        })
    }

    fun animation() {

        databinding.animationImg.animate().apply {
            duration = 1000
            alpha(0.5f)
            translationYBy(20f)
        }.withEndAction {
            databinding.animationImg.animate().apply {
                duration = 1000
                alpha(1f)
                translationYBy(-20f)
            }.withEndAction {

                //if data don't received from api animation again
                if(!data_recieved){
                    animation()
                }

            }.start()
        }.start()
    }

}