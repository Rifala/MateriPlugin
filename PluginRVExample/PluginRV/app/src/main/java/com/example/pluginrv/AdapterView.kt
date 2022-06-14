package com.example.pluginrv


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pluginrv.databinding.ListRvBinding

class AdapterView(val list:List<DataView>):RecyclerView.Adapter<AdapterView.ViewHolder>() {
    // class ViewHolder, seperti yang tertera diatas AdapterView.ViewHolder, sehingga kelas ini wajib di buat
    // dan wajib extends Rescyler.ViewHolder
    class ViewHolder(val binding: ListRvBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(dataView: DataView) {
            binding.tvTitle.text = dataView.title
            binding.tvDes.text = dataView.des
            binding.ivImg.setImageResource(dataView.img)
        }

    }

    // menampilkan setiap data dalam bentuk list, sesuai pada R.layout.list_rv
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListRvBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.list_rv,parent, false)))
    }

    // memdapatkan data berdasarkan posisi / index karena data berbentuk list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    // menetukan size dari recylerview
    override fun getItemCount(): Int {
        return list.size
    }
}