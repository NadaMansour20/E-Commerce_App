package com.android.e_commerce_app.ui.cartfragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.databinding.FragmentCartBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem

class CartFragment : BaseFragment<CartViewModel,FragmentCartBinding>() {

//    companion object {
//        fun newInstance() = CartFragment()
//    }


    var cartAdapter=CartAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.cvm=viewModel


        databinding.cartRecyclerview.adapter=cartAdapter

        viewModel.getCartProducts()

        observeData()


        cartAdapter.product_Clicked=object :ClickListener{
            override fun add_FavClick(position: Int, item: ProductsItem?, flag: Int) {
                TODO("Not yet implemented")
            }

            override fun add_Item(item: ProductsItem?, add: Int?) {

                val Product = ProductsItem(item?.favOrNot,add,item?.addToCart,item?.thumbnail,
                    item?.title,item?.price,item?.id!!)


                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

            }

            override fun add_Cart(item: ProductsItem?) {
                TODO("Not yet implemented")
            }

            override fun add_minesButton(item: ProductsItem?,add:Int?) {
               val Product = ProductsItem(item?.favOrNot,add,item?.addToCart,item?.thumbnail,
                    item?.title,item?.price,item?.id!!)

                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

            }

        }



    }


    override fun get_layout(): Int {
        return R.layout.fragment_cart
    }

    override fun get_viewModel(): CartViewModel {
        return ViewModelProvider(this).get(CartViewModel::class.java)
    }

    fun observeData(){

        viewModel.cart_items.observe(viewLifecycleOwner,Observer{

            cartAdapter.notify(it)

            databinding.noItemsInTheCart.isVisible=false
        })
    }



}