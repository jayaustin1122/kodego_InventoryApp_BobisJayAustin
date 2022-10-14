package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.kodeog.inventory.app.bobisjay.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    //Binding the xml to kt.
    private lateinit var binding : ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //button binding
        binding.btGetName.setOnClickListener (){
            var name = binding.etvName.text.toString()
            binding.txtName.text = name
            //combining button and spinner.
            var spinnerItem : String = binding.spinner1.selectedItem.toString()
            Toast.makeText(applicationContext,spinnerItem,Toast.LENGTH_SHORT).show()

        }
        //binding radio button
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, checkedOption ->
            when(checkedOption) {
                R.id.rd1 -> Toast.makeText(applicationContext,"Option 1 Selected",Toast.LENGTH_SHORT).show()
                R.id.rd2 -> Toast.makeText(applicationContext,"Option 2 Selected",Toast.LENGTH_SHORT).show()
                R.id.rd3 -> Toast.makeText(applicationContext,"Option 3 Selected",Toast.LENGTH_SHORT).show()
            }
        }
        //binding checkbox 1
        binding.cb1.setOnClickListener {
            if (binding.cb1.isChecked){
                Toast.makeText(applicationContext,"Checkbox 1 is checked",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"Checkbox 1 is unchecked",Toast.LENGTH_SHORT).show()
            }
        }
        //binding checkbox 2
        binding.cb2.setOnClickListener {
            if (binding.cb2.isChecked) {
                Toast.makeText(applicationContext, "Checkbox 2 is checked", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(applicationContext, "Checkbox 2 is unchecked", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        //Using a Spinner
        val data = arrayListOf<String>("Option 1","Option 2","Option 3")
        val adaptorParent = ArrayAdapter(applicationContext,R.layout.textview,data)

        binding.spinner1.adapter = adaptorParent

        binding.switchButton.setOnClickListener {
            if(binding.switchButton.isChecked){
                Toast.makeText(applicationContext, "On", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Off", Toast.LENGTH_SHORT).show()
            }
        }
    }
}