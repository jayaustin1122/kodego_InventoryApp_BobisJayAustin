package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TableLayout
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.kodeog.inventory.app.bobisjay.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    //Binding the xml to kt.
    private lateinit var binding : ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //to pass data to different activities
        //sample
        var myData1 = "This is Data 1"
        var myData2 = "This is Data 2"
        var myData3 = "This is Data 3"


        //calling all fragments
        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()
        val fragmentThree = FragmentThree()

        var bundle1 = Bundle()
        bundle1.putString("data1",myData1)
        fragmentOne.arguments = bundle1

        var bundle2 = Bundle()
        bundle2.putString("data2",myData2)
        fragmentTwo.arguments = bundle2

        var bundle3 = Bundle()
        bundle3 .putString("data3",myData3)
        fragmentThree.arguments = bundle3
        // to call the initial fragment display in screen
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentMain.id,fragmentOne)
            commit()
        }
        // to bind the table layout in buttons navigations
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            //implement functions
            override fun onTabSelected(tab: TabLayout.Tab?) {
                 if (tab?.position==0){
                     //accessing button 1 tab
                        supportFragmentManager.beginTransaction().apply {
                            replace(binding.fragmentMain.id,fragmentOne)
                            // creating a backstack
                            addToBackStack(null)
                            commit()
                        }
                }else if (tab?.position==1){
                    //accessing button 2
                    supportFragmentManager.beginTransaction().apply {
                        replace(binding.fragmentMain.id,fragmentTwo)
                        // creating a backstack
                        addToBackStack(null)
                        commit()
                    }
                }else if (tab?.position==2){
                     //accessing button 3
                     supportFragmentManager.beginTransaction().apply {
                         replace(binding.fragmentMain.id,fragmentThree)
                         // creating a backstack
                         addToBackStack(null)
                         commit()
                     }
                 }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
//        //accessing button 1
//        binding.button.setOnClickListener(){
//            supportFragmentManager.beginTransaction().apply {
//                replace(binding.fragmentMain.id,fragmentOne)
//                // creating a backstack
//                addToBackStack(null)
//                commit()
//            }
//        }
//        //accessing button 2
//        binding.button2.setOnClickListener(){
//            supportFragmentManager.beginTransaction().apply {
//                replace(binding.fragmentMain.id,fragmentTwo)
//                // creating a backstack
//                addToBackStack(null)
//                commit()
//            }
//        }
//        //accessing button 3
//        binding.button3.setOnClickListener(){
//            supportFragmentManager.beginTransaction().apply {
//                replace(binding.fragmentMain.id,fragmentThree)
//                // creating a backstack
//                addToBackStack(null)
//                commit()
//            }
//        }
    }
}

