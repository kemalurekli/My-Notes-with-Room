package com.kemalurekli.mynotes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.kemalurekli.mynotes.databinding.FragmentNewNoteBinding


class NewNoteFragment : Fragment() {
    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.new_note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_note -> {
                //Save codes
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