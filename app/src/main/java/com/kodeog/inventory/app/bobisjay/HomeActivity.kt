package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodeog.inventory.app.bobisjay.databinding.ActivityHomeBinding
import com.kodeog.inventory.app.bobisjay.databinding.RowItemBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productsList = mutableListOf<Products>(
            Products(R.drawable.ic_baseline_desktop_windows_24,"Desktop","This is for Computer parts and accessories."),
            Products(R.drawable.ic_baseline_edit_24,"Pens","This is Pencil category."),
            Products(R.drawable.ic_baseline_directions_car_24,"Cars","This is for car parts."),
            Products(R.drawable.ic_baseline_desktop_windows_24,"Desktop","This is for Computer parts and accessories."),
            Products(R.drawable.ic_baseline_edit_24,"Pens","This is Pencil category."),
            Products(R.drawable.ic_baseline_directions_car_24,"Cars","This is for car parts."),
            Products(R.drawable.ic_baseline_desktop_windows_24,"Desktop","This is for Computer parts and accessories."),
            Products(R.drawable.ic_baseline_edit_24,"Pens","This is Pencil category."),
            Products(R.drawable.ic_baseline_directions_car_24,"Cars","This is for car parts."),
            Products(R.drawable.ic_baseline_desktop_windows_24,"Desktop","This is for Computer parts and accessories."),
            Products(R.drawable.ic_baseline_edit_24,"Pens","This is Pencil category."),
            Products(R.drawable.ic_baseline_directions_car_24,"Cars","This is for car parts."),
            Products(R.drawable.ic_baseline_desktop_windows_24,"Desktop","This is for Computer parts and accessories."),
            Products(R.drawable.ic_baseline_edit_24,"Pens","This is Pencil category."),
            Products(R.drawable.ic_baseline_directions_car_24,"Cars","This is for car parts."),
            Products(R.drawable.ic_baseline_desktop_windows_24,"Desktop","This is for Computer parts and accessories."),
            Products(R.drawable.ic_baseline_edit_24,"Pens","This is Pencil category."),
            Products(R.drawable.ic_baseline_directions_car_24,"Cars","This is for car parts."),






            )
        val adapter = ProductAdapter(productsList)
        binding.myRecyclerView.adapter = adapter
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}