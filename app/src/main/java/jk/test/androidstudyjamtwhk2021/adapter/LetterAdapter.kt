package jk.test.androidstudyjamtwhk2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jk.test.androidstudyjamtwhk2021.R
import jk.test.androidstudyjamtwhk2021.fragment.LetterListFragmentDirections
import kotlinx.android.synthetic.main.item_view.view.*

class LetterAdapter :
    ListAdapter<Char, RecyclerView.ViewHolder>(
        latterDiffCallback
    ) {
    inner class LatterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(str: Char) {
            view.button_item.text = str.toString()
            view.button_item.setOnClickListener {
                val action =
                    LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(str.toString())
                view.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LatterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            ).apply {
                accessibilityDelegate = Accessibility
            }
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LatterViewHolder) {
            holder.onBind(getItem(position))
        }
    }

    companion object Accessibility : View.AccessibilityDelegate() {
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            val customString = host?.context?.getString(R.string.look_up_words)
            val customClick = AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfo.ACTION_CLICK,
                customString
            )
            info?.addAction(customClick)
        }
    }
}

val latterDiffCallback = object : DiffUtil.ItemCallback<Char>() {
    override fun areItemsTheSame(oldItem: Char, newItem: Char): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Char, newItem: Char): Boolean {
        return oldItem == newItem
    }
}