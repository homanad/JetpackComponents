package com.hmman.roomdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hmman.roomdemo.databinding.ItemSubcriberBinding
import com.hmman.roomdemo.db.Subcriber

class SubcriberAdapter(private val subcribers: List<Subcriber>) :
    RecyclerView.Adapter<SubcriberAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: ItemSubcriberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subcriber: Subcriber) {
            binding.textName.text = subcriber.name
            binding.textEmail.text = subcriber.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemSubcriberBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_subcriber, parent, false)
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return subcribers.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(subcribers[position])
    }

}