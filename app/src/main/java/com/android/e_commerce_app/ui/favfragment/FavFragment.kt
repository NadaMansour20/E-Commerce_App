package com.android.e_commerce_app.ui.favfragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.databinding.FragmentFavBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem

class FavFragment :BaseFragment<FavViewModel,FragmentFavBinding>(){
//
//    companion object {
//        fun newInstance() = FavFragment()
//    }


    var favAdapter=FavAdapter(null)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.ffvm=viewModel

        databinding.favRecyclerview.adapter=favAdapter


        observeData()


        //receive data of user after login
        val bundle=arguments

        val userItem = bundle?.getSerializable("user_object") as? Entity1

        if(userItem!=null){

            viewModel.getFavProducts(userItem.id)


            click(userItem.id)
        }


    }




    override fun get_layout(): Int {
        return R.layout.fragment_fav
    }

    override fun get_viewModel(): FavViewModel {
        return ViewModelProvider(this).get(FavViewModel::class.java)
    }

    fun click(user_id:Int){
        favAdapter.product_Clicked=object : ClickListener {


            override fun add_FavClick(position: Int, item: ProductsItem?, flag: Int) {
                TODO("Not yet implemented")
            }

            override fun add_Item(item: ProductsItem?, add: Int?) {
                TODO("Not yet implemented")
            }

            override fun add_Cart(item: ProductsItem?) {

                val Product = ProductsItem(item?.favOrNot,item?.addNumber!!,true,item.thumbnail,item.rating,item.description,
                    item.title,item.price,item.id,item.stock,user_id)

                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)



            }

            override fun add_minesButton(item: ProductsItem?, add: Int?) {
                TODO("Not yet implemented")
            }

            override fun addHolder(position: Int, item: ProductsItem?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun observeData(){

        viewModel.favItems.observe(viewLifecycleOwner, Observer {

            favAdapter.notify(it)

            databinding.noFavItem.isVisible=it.isNullOrEmpty()
        })

    }


}