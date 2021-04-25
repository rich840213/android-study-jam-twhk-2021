package jk.test.androidstudyjamtwhk2021.fragment

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jk.test.androidstudyjamtwhk2021.R
import jk.test.androidstudyjamtwhk2021.adapter.LetterAdapter
import jk.test.androidstudyjamtwhk2021.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private var isLinearLayoutManager = true
    private val latterAdapter = LetterAdapter()

    private val list = 'A'.rangeTo('Z').toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = latterAdapter
        chooseLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun chooseLayout() {
        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(context, 4)
            }
        }
        updateAdapter()
    }

    private fun updateAdapter() {
        latterAdapter.submitList(list)
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null) return

        menuItem.icon = if (isLinearLayoutManager) {
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
        } else {
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
        }
    }
}