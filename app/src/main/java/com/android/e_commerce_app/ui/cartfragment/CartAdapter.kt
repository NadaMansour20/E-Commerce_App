package com.android.e_commerce_app.ui.cartfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ItemDesignCartBinding
import com.android.e_commerce_app.ui.ClickListener
import com.android.e_commerce_app.ui.api.ProductsItem

class CartAdapter(var items:List<ProductsItem?>?) :Adapter<CartAdapter.ItemViewHolder>(){


    var product_Clicked:ClickListener?=null




    //holder is the special object to each item in recycler_view
    class ItemViewHolder(var homeBinding:ItemDesignCartBinding):ViewHolder(homeBinding.root){

        var cnAdd=0
        var sum=0


        fun bind(itemBinding: ProductsItem?){
            homeBinding.cartvm=itemBinding
            homeBinding.invalidateAll()  //to check all items is bind
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding:ItemDesignCartBinding=DataBindingUtil.
        inflate(LayoutInflater.from(parent.context),R.layout.item_design_cart,parent,false)
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


                holder.homeBinding.minesImageButton.setOnClickListener {

                    holder.cnAdd--

                    holder.sum+=holder.cnAdd

                    holder.homeBinding.numOfAddOrMines.text=holder.cnAdd.toString()


                    product_Clicked?.add_Item(items!![position],holder.cnAdd)
                }

                holder.homeBinding.addImageButton.setOnClickListener {

                    holder.cnAdd++

                   holder.sum+=holder.cnAdd

                    holder.homeBinding.numOfAddOrMines.text=holder.cnAdd.toString()

                    product_Clicked?.add_Item(items!![position],holder.cnAdd)
                }


            }




    }

    fun notify(item:List<ProductsItem?>?){
        items=item
        notifyDataSetChanged()
    }
}