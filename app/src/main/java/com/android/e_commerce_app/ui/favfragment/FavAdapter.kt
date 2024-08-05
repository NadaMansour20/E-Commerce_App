package com.android.e_commerce_app.ui.favfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ItemDesignBinding
import com.android.e_commerce_app.ui.api.ProductsItem

class FavAdapter(var list_item:List<ProductsItem?>?):Adapter<FavAdapter.FavViewHolder>() {


    class FavViewHolder(var itemBinding:ItemDesignBinding):RecyclerView.ViewHolder(itemBinding.root){

        fun bind(item:ProductsItem?){
            itemBinding.itemDesign=item
            itemBinding.invalidateAll()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val itemBinding:ItemDesignBinding=DataBindingUtil.
        inflate(LayoutInflater.from(parent.context), R.layout.item_design,parent,false)

        return FavViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {

        return list_item?.size?:0
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val item: ProductsItem? =list_item?.get(position)

        holder.bind(item)
    }
}