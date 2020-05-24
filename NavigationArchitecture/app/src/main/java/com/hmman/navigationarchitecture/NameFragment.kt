package com.hmman.navigationarchitecture


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hmman.navigationarchitecture.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.submitButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.edtName.text.toString())) {
                viewModel.name.value = binding.edtName.text.toString()
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment)
            } else Toast.makeText(activity, "Input name", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }


}
