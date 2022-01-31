package com.kemalurekli.mynotes.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.kemalurekli.mynotes.R
import com.kemalurekli.mynotes.databinding.FragmentNewNoteBinding
import com.kemalurekli.mynotes.model.Note
import com.kemalurekli.mynotes.viewmodel.MainFragmentViewModel
import com.kemalurekli.mynotes.viewmodel.NewNoteFragmentViewModel


class NewNoteFragment : Fragment() {
    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : NewNoteFragmentViewModel
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
        viewModel = ViewModelProvider(this)[NewNoteFragmentViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.new_note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_note -> {
                if (binding.etText.text != null && binding.etText.text.toString() != ""){

                    var note = Note(binding.etText.text.toString())
                    viewModel.saveRoom(note)
                    Navigation.findNavController(requireView()).navigate(NewNoteFragmentDirections.actionNewNoteFragmentToMainFragment())
                }else{
                    Toast.makeText(requireContext(),"Please write a note",Toast.LENGTH_LONG).show();
                }
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