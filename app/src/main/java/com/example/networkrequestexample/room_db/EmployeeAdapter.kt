package com.example.networkrequestexample.room_db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkrequestexample.R

class EmployeeAdapter(var list: List<Employee>?) :
    RecyclerView.Adapter<EmployeeAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.tv_name)
        val departmentTextView = itemView.findViewById<TextView>(R.id.tv_department)
        val designationTextView = itemView.findViewById<TextView>(R.id.tv_designation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_employee, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list?.get(position)
        holder.nameTextView.text = item?.name
        holder.departmentTextView.text = item?.department
        holder.designationTextView.text = item?.designation
    }

    fun update(list: List<Employee>?) {
        this.list = list
        notifyDataSetChanged()
    }
}