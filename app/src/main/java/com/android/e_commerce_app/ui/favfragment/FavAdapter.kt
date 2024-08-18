package com.android.e_commerce_app.ui.favfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ItemDesignFavBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem

class FavAdapter(var items:List<ProductsItem?>?) :Adapter<FavAdapter.ItemViewHolder>(){


    var product_Clicked:ClickListener?=null




    //holder is the special object to each item in recycler_view
    class ItemViewHolder(var homeBinding:ItemDesignFavBinding):ViewHolder(homeBinding.root){


        fun bind(itemBinding: ProductsItem?){
            homeBinding.fav=itemBinding
            homeBinding.invalidateAll()  //to check all items is bind
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding:ItemDesignFavBinding=DataBindingUtil.
        inflate(LayoutInflater.from(parent.context),R.layout.item_design_fav,parent,false)
        return ItemViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }




    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: ProductsItem? = items?.get(position)
        holder.bind(item)


        // click to add product in like list
            if(product_Clicked!=null){

                holder.homeBinding.favCart.setOnClickListener {

                    product_Clicked?.add_Cart(items!![position])
                }


            }


    }

    fun notify(item:List<ProductsItem?>?){
        items=item
        notifyDataSetChanged()
    }
}