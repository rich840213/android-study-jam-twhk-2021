package jk.test.androidstudyjamtwhk2021.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jk.test.androidstudyjamtwhk2021.R
import jk.test.androidstudyjamtwhk2021.fragment.WordListFragment
import kotlinx.android.synthetic.main.item_view.view.*

class WordAdapter(private val context: Context) :
    ListAdapter<String, RecyclerView.ViewHolder>(
        wordDiffCallback
    ) {
    inner class WordViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(data: String) {
            view.button_item.text = data
            view.button_item.setOnClickListener {
                val queryUrl: Uri = Uri.parse("${WordListFragment.SEARCH_PREFIX}$data")
                startActivity(context, Intent(Intent.ACTION_VIEW, queryUrl), null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WordViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WordViewHolder) {
            holder.onBind(getItem(position))
        }
    }
}

val wordDiffCallback = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}