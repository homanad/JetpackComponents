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
import com.hmman.navigationarchitecture.databinding.FragmentEmailBinding

/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.submitButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.edtEmail.text.toString())) {
                viewModel.email.value = binding.edtEmail.text.toString()
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment)
            } else Toast.makeText(activity, "Input email", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }


}
