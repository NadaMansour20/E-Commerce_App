package com.android.e_commerce_app.ui.home_fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.databinding.FragmentHomeBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem
import com.android.e_commerce_app.ui.productdetailsfragment.ProductDetailsFragment


class HomeFragment :BaseFragment<HomeFragmentViewModel,FragmentHomeBinding>(){

//    companion object {
//        fun newInstance() = HomeFragment()
//    }

    //var itemList:MutableList<Category>?=null


    var homeAdapter=HomeAdapter(null)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.fvm=viewModel

        databinding.recyclerView1.adapter=homeAdapter

        viewModel.get_all_product()

        observe_data()


        val bundle=arguments

        val userItem = bundle?.getSerializable("user_object") as? Entity1

        if(bundle!=null){
            if(userItem!=null){
                click(userItem.id)
                Log.e("Correccccccccccct","Login+${userItem}")

            }
            else{
                Log.e("Errrrrrrrrrrrrrrror","Login+${userItem}")
            }

        }
        else{
            Log.e("Errrrrrrrrrrrrrrror","Bundelllllllll+${userItem}")

        }







    }

    override fun get_layout(): Int {
        return R.layout.fragment_home
    }

    override fun get_viewModel(): HomeFragmentViewModel {
        return ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }


    fun click(user_id:Int){

        homeAdapter.product_Clicked=object : ClickListener {

            lateinit var Product: ProductsItem


            override fun add_FavClick(position: Int, item: ProductsItem?, flag:Int) {


                if(flag%2==0) {
                    Product = ProductsItem(true,item?.addNumber!!,item.addToCart,item.thumbnail,item.rating,item.description,
                        item.title,item.price,item.id,item.stock,user_id)
                }
                else{
                    Product = ProductsItem(false,item?.addNumber!!,item.addToCart,item.thumbnail,item.rating,item.description,
                        item.title,item.price,item.id,item.stock,user_id)

                }

                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                val fav_products=MyDataBase.getDataBase().productDao().getFavProduct(user_id)


                Log.e("Favvvvvvvvvvvvvvvv","correctttttt${fav_products}")



            }

            override fun add_Item(item: ProductsItem?, add: Int?) {

                Product = ProductsItem(item?.favOrNot,add!!,item?.addToCart,item?.thumbnail,item?.rating,item?.description,
                    item?.title,item?.price,item?.id!!,item.stock,user_id)


                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

//                val get_product=MyDataBase.getDataBase().productDao().getProduct(item.id)
//
//                Log.e("addItemmmmmmmmmmmmmm","correctttttt${get_product}")

            }

            override fun add_Cart(item: ProductsItem?) {

                Product = ProductsItem(item?.favOrNot,item?.addNumber!!,true,item.thumbnail,item.rating,item.description,
                    item.title,item.price,item.id,item.stock,user_id)


                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                val get_product=MyDataBase.getDataBase().productDao().getCartProduct(item.id)

                Log.e("addCarttttttttt","correctttttt${get_product}")

            }

            override fun add_minesButton(item: ProductsItem?, add:Int?) {
                TODO("Not yet implemented")
            }

            override fun addHolder(position: Int, item: ProductsItem?) {

                //to transfer details of products

                val bundle=Bundle().apply {
                    putSerializable("product_object",item)
                }

                val secondFragment = ProductDetailsFragment().apply {
                    arguments = bundle
                }
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container_frame, secondFragment) // استبدال fragment_container بالـ ID الصحيح لحاوية الـ Fragment
                    .addToBackStack(null) // إضافة المعاملة إلى الـ BackStack حتى يمكن للمستخدم العودة للـ Fragment الأول
                    .commit()
            }

        }
    }
    fun observe_data() {


        viewModel.all_products.observe(viewLifecycleOwner, Observer {
            homeAdapter.notify(it)

        })


        viewModel.progress.observe(viewLifecycleOwner, Observer {

            databinding.homeProgressbar.isVisible=it
        })

    }





}