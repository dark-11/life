package com.lifetap.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lifetap.assignment.R
import com.lifetap.assignment.databinding.RowItemImageBinding
import com.lifetap.assignment.utils.Border
import com.lifetap.assignment.utils.CircleAnimation
import com.lifetap.assignment.utils.CircleView

class LifeAdapter : RecyclerView.Adapter<LifeAdapter.LifeViewHolder>() {

lateinit var  binding : RowItemImageBinding
    inner class LifeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var item1 = view.findViewById<CircleView>(R.id.cvDummy)
        var item2 = view.findViewById<Border>(R.id.borderView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_image, parent, false)
        return LifeViewHolder(view);
    }

    override fun onBindViewHolder(holder: LifeViewHolder, position: Int) {
        holder.item1.setOnClickListener { it ->
            val border = holder.item2
            border!!.loaded = true
            val animation = CircleAnimation(border!!, 360)
            animation.duration = 1000
            border!!.startAnimation(animation)
        }

    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun getItemViewType(position: Int): Int {
        return position

    }
}