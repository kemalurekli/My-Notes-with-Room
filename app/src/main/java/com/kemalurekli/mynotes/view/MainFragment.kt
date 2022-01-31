package com.kemalurekli.mynotes.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kemalurekli.mynotes.R
import com.kemalurekli.mynotes.adapter.NoteAdapter
import com.kemalurekli.mynotes.databinding.FragmentMainBinding
import com.kemalurekli.mynotes.viewmodel.MainFragmentViewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : MainFragmentViewModel
    private val noteAdapter = NoteAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]

        binding.NoteRv.layoutManager = LinearLayoutManager(context)
        binding.NoteRv.adapter = noteAdapter
        viewModel.getDataFromSQLite()
        observeLiveData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_note -> {
                Navigation.findNavController(requireView()).navigate(MainFragmentDirections.actionMainFragmentToNewNoteFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun observeLiveData () {
        viewModel.notes.observe(viewLifecycleOwner, Observer { notes ->
            notes?.let {
                noteAdapter.updateNoteList(it)
            }

        })
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
