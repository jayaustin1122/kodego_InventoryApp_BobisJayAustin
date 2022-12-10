package com.kodeog.inventory.app.bobisjay

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodeog.inventory.app.bobisjay.databinding.ActivityHomeBinding
import com.kodeog.inventory.app.bobisjay.databinding.AddItemDialogBinding
import com.kodeog.inventory.app.bobisjay.databinding.PopupDialogyesornoBinding
import com.kodeog.inventory.app.bobisjay.databinding.QtyDeleteDialogBinding
import com.kodeog.inventory.app.bobisjay.databinding.RowItemBinding
import java.text.FieldPosition

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    //declare adapter outside to use in dialog edit
    lateinit var adapter : ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //data source
        var productsList = mutableListOf<Products>(
            Products(R.drawable.s1,"Nike Air Jordan 3","The top-selling Air Jordan 3, seen here in the Retro “Infrared 23” colorway, was first released in 1988, when Michael Jordan received his first NBA Most Valuable Player award",1),
            Products(R.drawable.s2,"Nike AIR FORCE 1 LOW","Named for the plane that carries the president (and later celebrated by Nelly), the Air Force 1 has remained an icon.",34),
            Products(R.drawable.s3,"Nike FREE 5.0+ 2014","Nike’s top running shoe on the list is lightweight and comes in a number of colorways, including this, “Blue Lagoon / Clearwater/Bright Crimson.”",34),
            Products(R.drawable.s4,"Nike Air Jordan 6","Another pair of high-priced Jordan kicks (note all the Jumpman logos). Jordan sneakers alone pulled in more than 2 billion in American sales in 2013.",22),
            Products(R.drawable.s5,"Nike AIR MONARCH IV","Nike’s cheap, chunky, dad-centric cross-trainers won’t win any sneakerhead love anytime soon. But they still make the Swoosh a ton of cash.",41),
            Products(R.drawable.s6,"Nike ROSHE RUN","These “lifestyle” sneaks, maybe Nike’s most fashion-centric on the list, debuted on the market in 2012 and have edged close to the top of the Swoosh’s sales rankings ever since.",1),
            Products(R.drawable.s7,"Under Armour HIGHLIGHT MC","Under Armour is only on the best-seller list once, but it’s still a big deal for a shoe company that only last year overtook Adidas to become the No. 2 sportswear brand in America.",34),



            )
        //put value which is productlist variable
        adapter = ProductAdapter(productsList)

        //calling onClick here going from productAdapter
        adapter.onItemClick = {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("itemName",it.itemName)
            intent.putExtra("itemDescription" ,it.itemDescription)
            intent.putExtra("imageItem",it.imageItem)
            intent.putExtra("itemQuantity",it.quantity)
            startActivity(intent)
        }
        //update
        adapter.onUpdateButtonClick = { item:Products, position:Int ->
            showUpdateDialog(item,position)
        }
        //delete
        adapter.onDeleteButtonClick= { item:Products, position:Int ->
            showDeletePopup(item,position)

        }
        //Adding button floating in home
        binding.floatingActionButton2.setOnClickListener(){
            showAddDialog()
        }

        binding.myRecyclerView.adapter = adapter
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)


    }
    //updating quantity dialog
    fun showUpdateDialog(item:Products,position: Int){
        val dialog = Dialog(this)
        val binding : QtyDeleteDialogBinding = QtyDeleteDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnUpdate.setOnClickListener (){
            var newQty : Int = binding.etQtyDialog.text.toString().toInt()
            adapter.products[position].quantity = newQty
            adapter.notifyDataSetChanged()
            Toast.makeText(applicationContext, "Success Item is updated", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }
    //adding item dialog.
    fun showAddDialog(){
        val dialog = Dialog(this)
        val binding : AddItemDialogBinding = AddItemDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()


        // options to use image in spinner dropdown.
        val images = arrayListOf<String>("ic_baseline_desktop_windows_24", "twitter_logo",
            "ic_baseline_directions_car_24",
                "ic_baseline_lock_24",
                "ic_baseline_edit_24",
                "ic_baseline_person_24",
                "facebook_logo",
                "google_logo")
        // binding Textview layout xml to home
        val spinnerAdapter = ArrayAdapter(applicationContext,R.layout.textview,images)
        //binding the images to spinner
        binding.spinner.adapter = spinnerAdapter

        //calling the button to execute the adding
        binding.btnAddItem.setOnClickListener() {
            //converting images string to int. to read the images
            var image : Int = resources.getIdentifier(binding.spinner.selectedItem.toString(),"drawable",packageName)
            var itemName: String = binding.etItemName.text.toString()
            var itemDesc : String = binding.etItemDescription.text.toString()
            var itemQuantity : Int = binding.etItemQuantity.text.toString().toInt()

            // products is the main source of data
            adapter.products.add(Products(image, itemName, itemDesc, itemQuantity))
            adapter.notifyItemInserted(adapter.itemCount + 1)
            Toast.makeText(applicationContext, "Success Item is added", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }
    fun showDeletePopup(item: Products,position:Int){
        val dialog = Dialog(this)
        val binding : PopupDialogyesornoBinding = PopupDialogyesornoBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnYes.setOnClickListener(){
            adapter.products.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(applicationContext, "Success Item is deleted", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        binding.btnNo.setOnClickListener(){
            dialog.dismiss()
        }
    }
}
