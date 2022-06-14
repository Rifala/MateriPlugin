package com.example.week2room.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week2room.Room.Entity
import com.example.week2room.databinding.ListitemBinding

class MainAdapter(private var entity : MutableList<Entity>,private var listener : MainAdapter.onClick): RecyclerView.Adapter<MainAdapter.mainViewHolder>() {

    inner class mainViewHolder(val binding : ListitemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainViewHolder {
        return mainViewHolder(ListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: mainViewHolder, position: Int) {
        holder.binding.apply{
            TvNama.text = entity[position].nama
            TvNama.setOnClickListener {
                listener.TextClick(entity[position])
            }
            iconUpdate.setOnClickListener{
                listener.onUpdate(entity[position])
            }
            iconDelete.setOnClickListener{
                listener.onDelete(entity[position])}
        }
    }

    override fun getItemCount(): Int {
        return entity.size
    }

    fun reloadRecycler(data : MutableList<Entity>){
        this.entity.clear()
        this.entity.addAll(data)
        notifyDataSetChanged()
    }


    interface onClick{
        fun TextClick (entity : Entity)
        fun onUpdate (entity: Entity)
        fun onDelete (entity: Entity)
    }

}