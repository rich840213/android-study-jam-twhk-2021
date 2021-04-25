package jk.test.androidstudyjamtwhk2021.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jk.test.androidstudyjamtwhk2021.R
import jk.test.androidstudyjamtwhk2021.adapter.WordAdapter
import jk.test.androidstudyjamtwhk2021.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {

    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!

    private lateinit var letterId: String

    private val args: WordListFragmentArgs by navArgs()
    private lateinit var wordAdapter: WordAdapter

    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        letterId = args.letter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        wordAdapter = WordAdapter(requireContext())

        val recyclerView = binding.recyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = wordAdapter
        }
        if (this::letterId.isInitialized) {
            val list = resources.getStringArray(R.array.words).toList()
                .filter { it.startsWith(letterId, ignoreCase = true) }
            wordAdapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}