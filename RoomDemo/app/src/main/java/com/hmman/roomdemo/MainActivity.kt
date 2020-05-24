package com.hmman.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hmman.roomdemo.databinding.ActivityMainBinding
import com.hmman.roomdemo.db.SubcriberDatabase
import com.hmman.roomdemo.db.SubcriberRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subcriberViewModel: SubcriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubcriberDatabase.getInstance(application).subcriberDAO
        val repository = SubcriberRepository(dao)
        val viewModelFactory = SubcriberViewModelFactory(repository)
        subcriberViewModel =
            ViewModelProvider(this, viewModelFactory).get(SubcriberViewModel::class.java)
        binding.viewModel = subcriberViewModel
        binding.lifecycleOwner = this

        displaySubcribers()
    }

    private fun displaySubcribers() {
        subcriberViewModel.subcribers.observe(this, Observer { its ->
//            Log.i("MYTAG", its.toString())
            val myAdapter = SubcriberAdapter(its)
            binding.recyclerviewSubcriber.apply {
                adapter = myAdapter
                layoutManager = GridLayoutManager(this@MainActivity, 1)
            }
        })
    }
}
