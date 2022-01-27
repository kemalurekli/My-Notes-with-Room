package com.kemalurekli.mynotes

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.kemalurekli.mynotes.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
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




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
