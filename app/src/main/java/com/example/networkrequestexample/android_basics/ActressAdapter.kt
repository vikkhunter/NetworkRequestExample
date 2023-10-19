package com.example.networkrequestexample.android_basics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkrequestexample.R

class ActressAdapter(val list: List<Actress>) :
    RecyclerView.Adapter<ActressAdapter.ActressViewHolder>() {
    class ActressViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.iv_photo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActressViewHolder {
        return ActressViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActressViewHolder, position: Int) {
        holder.imageView.setImageResource(list.get(position).image)
    }

    override fun getItemCount(): Int = list.size
}