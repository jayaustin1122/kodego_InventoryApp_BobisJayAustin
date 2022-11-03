package com.kodeog.inventory.app.bobisjay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodeog.inventory.app.bobisjay.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {
    lateinit var binding: FragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(layoutInflater)
        var textfromTestActivity = arguments?.getString("data3")
        binding.textViewFragment3.text = textfromTestActivity
        // Inflate the layout for this fragment
        return binding.root
    }

}