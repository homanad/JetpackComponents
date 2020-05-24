package com.hmman.navigationarchitecture


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hmman.navigationarchitecture.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.apply {
            startButton.setOnClickListener {
//            if (!TextUtils.isEmpty(binding.inputText.text.toString())) {
//                val bundle = bundleOf("input" to binding.inputText.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_nameFragment)
//            } else Toast.makeText(activity, "Input", Toast.LENGTH_SHORT).show()
            }
            termsButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_termsFragment)
            }
        }

        return binding.root
    }


}
