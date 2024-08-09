package com.android.e_commerce_app.ui.home_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.CategoryItemBinding
import com.android.e_commerce_app.ui.api.DataItem

class CategoryAdapter(var list:List<DataItem?>?):Adapter<CategoryAdapter.CategoryViewHolde>() {

    class CategoryViewHolde(val category:CategoryItemBinding):ViewHolder(category.root){

        fun bind(list:DataItem?){
            category.cvm=list
            category.invalidateAll()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolde {
        val Binding_ViewHolde:CategoryItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.category_item,parent,false)

        return CategoryViewHolde(Binding_ViewHolde)
    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }

    override fun onBindViewHolder(holder: CategoryViewHolde, position: Int) {

        val item: DataItem? =list!!.get(position)

        holder.bind(item)
    }


    fun notify(item:List<DataItem?>?){
        list=item
        notifyDataSetChanged()
    }
}