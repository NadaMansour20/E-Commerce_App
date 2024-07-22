package com.android.e_commerce_app.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ItemDesignBinding
import com.android.e_commerce_app.ui.ClickListener

class HomeCategoryAdapter(var items:List<Item_Category>?) :Adapter<HomeCategoryAdapter.ItemViewHolder>(){


    var fav_onclick:ClickListener?=null

    class ItemViewHolder(var homeBinding:ItemDesignBinding):ViewHolder(homeBinding.root){
        fun bind(itemBinding:Item_Category){
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

    var cn=1

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item_Category = items!!.get(position)
        holder.bind(item)

        // click to add product in like list
            if(fav_onclick!=null){

                holder.homeBinding.addToFavBtn.setOnClickListener {

                    fav_onclick?.add_FavClick(position, items!![position])

                    if(cn%2!=0) {

                        holder.homeBinding.addToFavBtn.setImageResource(R.drawable.blacklike)
                    }
                    else{
                        holder.homeBinding.addToFavBtn.setImageResource(R.drawable.like)
                    }
                    cn++
                }

            }


    }

    fun notify(item:MutableList<Item_Category>?){
        items=item
        notifyDataSetChanged()
    }
}