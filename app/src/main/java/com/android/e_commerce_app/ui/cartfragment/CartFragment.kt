package com.android.e_commerce_app.ui.cartfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.database.Entity1
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



        val bundle=arguments

        val userItem = bundle?.getSerializable("user_object") as? Entity1


        if(userItem!=null){

            viewModel.getCartProducts(userItem.id)
            click(userItem.id)
            observeData()


        }


    }


    override fun get_layout(): Int {
        return R.layout.fragment_cart
    }

    override fun get_viewModel(): CartViewModel {
        return ViewModelProvider(this).get(CartViewModel::class.java)
    }

    fun click(user_id:Int){

        cartAdapter.product_Clicked=object : ClickListener {
            override fun add_FavClick(position: Int, item: ProductsItem?, flag: Int) {
                TODO("Not yet implemented")
            }

            override fun add_Item(item: ProductsItem?, add: Int?) {

                val Product = ProductsItem(item?.favOrNot,add!!,item?.addToCart,item?.thumbnail,item?.rating,item?.description,
                    item?.title,item?.price,item?.id!!,item.stock,user_id)


                    MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                //update and receive data again
                viewModel.getCartProducts(user_id)


            }

            override fun add_Cart(item: ProductsItem?) {
                TODO("Not yet implemented")
            }

            override fun add_minesButton(item: ProductsItem?, add:Int?) {
                val Product = ProductsItem(item?.favOrNot,add!!,item?.addToCart,item?.thumbnail,item?.rating,item?.description,
                    item?.title,item?.price,item?.id!!,item.stock,user_id)


                    MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                viewModel.getCartProducts(user_id)

            }

            override fun addHolder(position: Int, item: ProductsItem?) {
                TODO("Not yet implemented")
            }

        }
        databinding.purchase.setOnClickListener {

            val total_price=databinding.apiPrice.text
            val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.setTitle("attention here")
            alertDialog.setMessage("Confirm your $ $total_price purchase?")

            alertDialog.setCancelable(false)

            alertDialog.setPositiveButton("OK") { dialog, which ->
                dialog.cancel()

                //empty the cart_fragment

                val products=MyDataBase.getDataBase().productDao().getCartProduct(user_id)
                MyDataBase.getDataBase().productDao().delete_cart_fragment(products)
                viewModel.getCartProducts(user_id)

                Toast.makeText(requireContext(),"Your purchase was completed successfully:)", Toast.LENGTH_LONG).show()

            }

            alertDialog.setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }

            alertDialog.create().show()
        }

    }

    fun observeData(){

        viewModel.cart_items.observe(viewLifecycleOwner,Observer{

            cartAdapter.notify(it)

            databinding.noItemsInTheCart.isVisible=it.isNullOrEmpty()
        })

        viewModel.text.observe(viewLifecycleOwner, Observer {

            databinding.apiPrice.text=it

        })

    }



}