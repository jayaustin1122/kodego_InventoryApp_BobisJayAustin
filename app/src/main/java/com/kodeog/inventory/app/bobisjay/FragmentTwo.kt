package com.kodeog.inventory.app.bobisjay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodeog.inventory.app.bobisjay.databinding.FragmentOneBinding
import com.kodeog.inventory.app.bobisjay.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    lateinit var binding: FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}