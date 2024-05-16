package com.example.teamproject_11.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.teamproject_11.databinding.ItemMostBinding
import com.example.teamproject_11.home.data.HomeVideoModel

class MostViewAdapter : RecyclerView.Adapter<MostViewAdapter.MyViewHolder>() {

    var itemList: List<HomeVideoModel> = listOf()

    interface OnItemClickListener {
        fun onItemClick(videoModel: HomeVideoModel)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    inner class MyViewHolder(private val binding: ItemMostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeVideoModel) {
            binding.ivMost.load(item.imgThumbnail) {
                crossfade(true)
            }
            binding.ivMost.clipToOutline = true

            itemView.setOnClickListener {
                listener?.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemMostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            listener?.onItemClick(itemList[position])
        }
    }

    fun setItems(data: List<HomeVideoModel>) {
        this.itemList = data
        notifyDataSetChanged()
    }
}