package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodeog.inventory.app.bobisjay.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // data coming from the home activity
        var itemName : String? = intent.getStringExtra("itemName")
        var itemDescription : String? = intent.getStringExtra("itemDescription")
        var imageItem : Int = intent.getIntExtra("imageItem",0)
        var itemQuantity : Int = intent.getIntExtra("itemQuantity",0)

        binding.textItemNameDisplay.text = itemName
        binding.imageItemProduct.setImageResource(imageItem)
        binding.textItemDescription.text = itemDescription
        binding.textQuantity.text = itemQuantity.toString()
    }
}