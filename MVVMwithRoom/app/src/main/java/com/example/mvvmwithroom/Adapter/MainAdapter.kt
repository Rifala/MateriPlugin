package com.example.mvvmwithroom.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithroom.Model.UserModel
import com.example.mvvmwithroom.databinding.ListitemBinding

class MainAdapter(val data: MutableList<UserModel>) : RecyclerView.Adapter<MainAdapter.viewHolder>()  {

    inner class viewHolder(val binding: ListitemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.apply {
            TvNama.text = data[position].name
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


    fun setData(item: List<UserModel>){
        data.clear()
        data.addAll(item)
        notifyDataSetChanged()
    }

}