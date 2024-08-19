package com.android.e_commerce_app.ui.home_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ItemDesignBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem

class HomeAdapter(var items:List<ProductsItem?>?) :Adapter<HomeAdapter.ItemViewHolder>(){


    var product_Clicked:ClickListener?=null




    //holder is the special object to each item in recycler_view
    class ItemViewHolder(var homeBinding:ItemDesignBinding):ViewHolder(homeBinding.root){

        var cn=1
        var cnAdd=0

        fun bind(itemBinding: ProductsItem?){
            homeBinding.itemDesign=itemBinding
            homeBinding.invalidateAll()  //to check all items is bind
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding:ItemDesignBinding=DataBindingUtil.
        inflate(LayoutInflater.from(parent.context),R.layout.item_design,parent,false)
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

                holder.homeBinding.productImage.setOnClickListener{
                    product_Clicked?.addHolder(position,items!![position])
                }

                holder.homeBinding.addToFavBtn.setOnClickListener {

                    holder.cn++

                    product_Clicked?.add_FavClick(position, items!![position],holder.cn)

                    if(holder.cn%2==0) {

                        holder.homeBinding.addToFavBtn.setImageResource(R.drawable.blacklike)
                    }
                    else{
                        holder.homeBinding.addToFavBtn.setImageResource(R.drawable.like)
                    }
                }

                holder.homeBinding.addToCart.setOnClickListener {

                    product_Clicked?.add_Cart(items!![position])
                }

                holder.homeBinding.addButton.setOnClickListener {

                    holder.cnAdd++
                    product_Clicked?.add_Item(items!![position],holder.cnAdd)
                }

            }


    }

    fun notify(item:List<ProductsItem?>?){
        items=item
        notifyDataSetChanged()
    }
}