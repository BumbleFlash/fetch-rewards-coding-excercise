package com.example.fetchrewardscodingexcercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexcercise.R
import com.example.fetchrewardscodingexcercise.model.HiringData

class HiringDataAdapter(val hiringDataList: List<HiringData>) :
    RecyclerView.Adapter<HiringDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HiringDataViewHolder {
        return HiringDataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HiringDataViewHolder, position: Int) {
        return holder.bind(hiringDataList[position])
    }

    override fun getItemCount(): Int {
        return hiringDataList.size
    }
}

class HiringDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val id: TextView = itemView.findViewById(R.id.id)
    private val listId: TextView = itemView.findViewById(R.id.list_id)
    private val name: TextView = itemView.findViewById(R.id.name)

    fun bind(hiringData: HiringData) {
        id.text = hiringData.id.toString()
        listId.text = hiringData.listId.toString()
        name.text = hiringData.name
    }
}