package com.kodeog.inventory.app.bobisjay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodeog.inventory.app.bobisjay.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    lateinit var binding : FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding fragment
        binding = FragmentOneBinding.inflate(layoutInflater)

        //paasing data to 1st fragment
        var textfromTestActivity = arguments?.getString("data1")
        binding.textViewFragment1.text = textfromTestActivity
        // Inflate the layout for this fragment
        return binding.root
    }
}