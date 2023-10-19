package com.example.networkrequestexample.android_basics

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.networkrequestexample.R

class NamesAdapter(val list: List<Student>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Student {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return list.get(position).id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        var viewHolder: ViewHolder

        if (convertView == null) {
            //first time
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.custom_list_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.textView = view.findViewById(R.id.tv_name)
            viewHolder.imageView = view.findViewById(R.id.iv_photo)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val student = list.get(position)
        viewHolder.textView.text = student.name

        Log.d("TAG", "getView: $position $convertView")

        return view
    }

    class ViewHolder {
        lateinit var textView: TextView
        lateinit var imageView: ImageView
    }
}