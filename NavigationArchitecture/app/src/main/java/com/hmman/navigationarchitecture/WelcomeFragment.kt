package com.hmman.navigationarchitecture


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hmman.navigationarchitecture.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.apply {
            txtName.text = viewModel.name.value
            txtEmail.text = viewModel.email.value
            termsButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
            }
        }

        return binding.root
    }


}
