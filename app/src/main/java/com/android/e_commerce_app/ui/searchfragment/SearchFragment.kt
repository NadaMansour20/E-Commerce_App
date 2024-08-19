package com.android.e_commerce_app.ui.searchfragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.databinding.FragmentSearchBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem
import com.android.e_commerce_app.ui.home_fragment.HomeAdapter
import com.android.e_commerce_app.ui.productdetailsfragment.ProductDetailsFragment

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
        search_click()
        click()





    }

    override fun get_layout(): Int {
        return R.layout.fragment_search
    }

    override fun get_viewModel(): SearchViewModel {

        return ViewModelProvider(this).get(SearchViewModel::class.java)
    }


    fun search_click(){
        // the action that taken when click on search_view
        databinding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                //fetch data from api
                viewModel.get_productBySearch(query!!)
                databinding.searchRecyclerView.adapter=searchAdapter

                return true


            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrBlank()){

                    viewModel.get_productBySearch(null)
                    databinding.searchRecyclerView.adapter=null
                    //Log.e("Nullllllllllll","Nulllllllll")

                }
                return false

            }

        })
    }


    var data_recieved=false
    fun data_observation(){

        //observe data to activity

        viewModel.search_item.observe(viewLifecycleOwner, Observer{

           searchAdapter.notify(it)

            databinding.animationImg.isVisible=false

            databinding.productNotFound.isVisible = it.isNullOrEmpty()
            data_recieved=true

        })
    }

    fun click(){

        searchAdapter.product_Clicked=object : ClickListener {

            lateinit var Product: ProductsItem


            override fun add_FavClick(position: Int, item: ProductsItem?, flag:Int) {


                if(flag%2==0) {
                    Product = ProductsItem(true,item?.addNumber,item?.addToCart,item?.thumbnail,item?.rating,item?.description,
                        item?.title,item?.price,item?.id!!,item.stock,0)
                }
                else{
                    Product = ProductsItem(false,item?.addNumber,item?.addToCart,item?.thumbnail,item?.rating,item?.description,
                        item?.title,item?.price,item?.id!!,item.stock,0)

                }

                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                // var get_product= MyDataBase.getInstance(context!!).productDao().getProduct(item.id)
               // var fav_products= MyDataBase.getDataBase().productDao().getFavProduct(0)


                // Log.e("Favvvvvvvvvvvvvvvv","correctttttt${fav_products}")



            }

            override fun add_Item(item: ProductsItem?, add: Int?) {

                Product = ProductsItem(item?.favOrNot,add,item?.addToCart,item?.thumbnail,item?.rating,item?.description,
                    item?.title,item?.price,item?.id!!,item.stock,0)


                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                //var get_product= MyDataBase.getDataBase().productDao().getProduct(item.id)

                // Log.e("addItemmmmmmmmmmmmmm","correctttttt${get_product}")

            }

            override fun add_Cart(item: ProductsItem?) {

                Product = ProductsItem(item?.favOrNot,item?.addNumber,true,item?.thumbnail,item?.rating,item?.description,
                    item?.title,item?.price,item?.id!!,item.stock,0)


                MyDataBase.getDataBase().productDao().insertProductsToDataBase(Product)

                //var get_product= MyDataBase.getDataBase().productDao().getCartProduct(0)

                //Log.e("addCarttttttttt","correctttttt${get_product}")

            }

            override fun add_minesButton(item: ProductsItem?,add:Int?) {
                TODO("Not yet implemented")
            }

            override fun addHolder(position: Int, item: ProductsItem?) {


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