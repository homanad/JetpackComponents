package com.hmman.navigationarchitecture


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hmman.navigationarchitecture.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        val input = arguments!!.getString("input")
        binding.textView.text = input

        return binding.root
    }


}
