package com.android.e_commerce_app.ui.productdetailsfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.databinding.DetailsProductBinding
import com.android.e_commerce_app.ui.api.ProductsItem
import com.bumptech.glide.Glide

class ProductDetailsFragment : BaseFragment<ProductDetailsViewModel,DetailsProductBinding>() {

//    companion object {
//        fun newInstance() = ProductDetailsFragment()
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       databinding.details=viewModel

        //receive data by Bundle from home fragment

        val bundle=arguments
        val productItem = bundle?.getSerializable("product_object") as? ProductsItem

        if(productItem!=null) {

            databinding.titleProduct.text = productItem.title.toString()
            databinding.stockApi.text = productItem.stock.toString()
            databinding.rating.rating = productItem.rating ?: 0f
            databinding.descriptionApi.text = productItem.description.toString()
            databinding.priceApi.text = productItem.price.toString()
            Glide.with(this).load(productItem.thumbnail).into(databinding.imageDetails)

            Log.e("Corrrect","Bundle+${productItem}")
        }
        else{
            Log.e("null","Bundle products is nullllllll")

        }



        val bundle2=arguments

        var userItem = bundle2?.getSerializable("user_object") as? Entity1


        if(userItem!=null) {

            var product: ProductsItem

            databinding.addCartDetails.setOnClickListener {

                product = ProductsItem(
                    productItem?.favOrNot,
                    productItem?.addNumber!!,
                    true,
                    productItem.thumbnail,
                    productItem.rating,
                    productItem.description,
                    productItem.title,
                    productItem.price,
                    productItem.id,
                    productItem.stock,
                    userItem.id
                )


                MyDataBase.getDataBase().productDao().insertProductsToDataBase(product)
            }
        }




    }
    override fun get_layout(): Int {
        return R.layout.details_product
    }

    override fun get_viewModel(): ProductDetailsViewModel {
        return ViewModelProvider(this).get(ProductDetailsViewModel::class.java)
    }



}