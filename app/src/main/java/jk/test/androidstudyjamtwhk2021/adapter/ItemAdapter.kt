package jk.test.androidstudyjamtwhk2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jk.test.androidstudyjamtwhk2021.R
import jk.test.androidstudyjamtwhk2021.model.Affirmation
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter : ListAdapter<Affirmation, RecyclerView.ViewHolder>(
    diffCallback
) {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(affirmation: Affirmation) {
            view.item_title.text = view.context.getString(affirmation.stringResourceId)
            view.item_image.setImageResource(affirmation.imageResourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.onBind(getItem(position))
        }
    }
}

val diffCallback = object : DiffUtil.ItemCallback<Affirmation>() {
    override fun areItemsTheSame(oldItem: Affirmation, newItem: Affirmation): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(
        oldItem: Affirmation,
        newItem: Affirmation
    ): Boolean {
        return oldItem == newItem
    }
}