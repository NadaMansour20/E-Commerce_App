package com.android.e_commerce_app.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ItemDesignBinding

class HomeCategoryAdapter(var items:List<Item_Category>?) :Adapter<HomeCategoryAdapter.ItemViewHolder>(){

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

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item_Category = items!!.get(position)
        holder.bind(item)

    }

    fun notify(item:MutableList<Item_Category>?){
        items=item
        notifyDataSetChanged()
    }
}