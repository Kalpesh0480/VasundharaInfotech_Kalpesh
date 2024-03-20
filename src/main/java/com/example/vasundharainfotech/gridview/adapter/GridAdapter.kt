package com.example.vasundharainfotech.gridview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.vasundharainfotech.R


public class GridAdapter(private val context: Context, private val gridItems: List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return gridItems.size
    }

    override fun getItem(position: Int): Any {
        return gridItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.textViewGridItem)
        textView.text = gridItems[position]
        return view
    }
}