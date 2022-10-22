package com.kodeog.inventory.app.bobisjay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodeog.inventory.app.bobisjay.databinding.RowItemBinding

class ProductAdapter (val products:List<Products>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    // to pass a setonclicklistener to the Home page.
    //lambda sample
    var onItemClick : ((Products)-> Unit)? = null
    inner class ProductViewHolder(val binding:RowItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemBinding.inflate(layoutInflater,parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.apply {
            imageItem.setImageResource(products[position].imageItem)
            textItemName.text = products[position].itemName
            textItemDescription.text = products[position].itemDescription
        }
        // to make the viewcard functional
        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(products[position])
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}