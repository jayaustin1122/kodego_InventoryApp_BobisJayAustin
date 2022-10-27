package com.kodeog.inventory.app.bobisjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kodeog.inventory.app.bobisjay.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    lateinit var binding : ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data source
        var images = listOf(
            R.drawable.ic_baseline_delete_24,
            R.drawable.ic_baseline_desktop_windows_24,
            R.drawable.ic_baseline_directions_car_24,
            R.drawable.ic_baseline_edit_24,
            R.drawable.ic_baseline_lock_24,
            R.drawable.ic_baseline_person_24
        )
        // to display 1 by 1 the datas or images.
        // final step in this tuts to properly display all the data's
        val adapter = ViewPagerAdapter(images)
        binding.viewPagerView.adapter = adapter
        // to combine viewpager with tablayout
        TabLayoutMediator(binding.tabLayout,binding.viewPagerView){tab,position ->

            // this is the name of every tab
            tab.text = "Tab ${position+1}"
        }.attach()
    }
}