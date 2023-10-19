package com.example.networkrequestexample.android_basics

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.networkrequestexample.R

class NamesRvAdapter(val list: List<Student>) : RecyclerView.Adapter<ViewHolder>() {
    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_name)
        val imageView: ImageView = view.findViewById(R.id.iv_photo)
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.iv_photo)
    }

    companion object {
        const val IMAGE_ITEM = 1
        const val NORMAL_ITEM = 2
    }

    var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.d("TAG", "onCreateViewHolder: ${count++}")

        var viewHolder: ViewHolder
        when (viewType) {
            IMAGE_ITEM -> {
                viewHolder = ImageViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.image_view, parent, false)
                )
            }

            NORMAL_ITEM -> {
                viewHolder = TextViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.custom_list_item, parent, false)
                )
            }

            else -> {
                viewHolder = TextViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.custom_list_item, parent, false)
                )
            }
        }

        return viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) IMAGE_ITEM else NORMAL_ITEM
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        when(holder) {
            is TextViewHolder -> {
                holder.textView.text = item.name
            }

            is ImageViewHolder -> {
                holder.imageView.setImageResource(R.drawable.android_logo_image)
            }
        }
    }
}