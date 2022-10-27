package com.kodeog.inventory.app.bobisjay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodeog.inventory.app.bobisjay.databinding.ItemViewPagerBinding

class ViewPagerAdapter(val images : List<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    //calling item view pager in layouts or xml.
    inner class ViewPagerViewHolder(val binding: ItemViewPagerBinding): RecyclerView.ViewHolder(binding.root)

    //give look to our screen the oncreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val  binding = ItemViewPagerBinding.inflate(layoutInflater,parent,false)
        return ViewPagerViewHolder(binding)

    }
    // put a value
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val image = images[position]
        //access binding
        holder.binding.apply {
            imageViewPager.setImageResource(image)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}