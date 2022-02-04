package com.kemalurekli.mynotes.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.kemalurekli.mynotes.R
import com.kemalurekli.mynotes.databinding.FragmentDetailsBinding
import com.kemalurekli.mynotes.model.Note
import com.kemalurekli.mynotes.viewmodel.DetailsFragmentViewModel
import com.kemalurekli.mynotes.viewmodel.NewNoteFragmentViewModel

class DetailsFragment : Fragment() {
    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : DetailsFragmentViewModel
    private var noteid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[DetailsFragmentViewModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            arguments?.let {
                noteid = DetailsFragmentArgs.fromBundle(it).noteId.toInt()
            }
        viewModel.getDataFromRoom(noteid)
        observeLiveData()

        binding.btDeleteNote.setOnClickListener {
            viewModel.deleteNoteFromRoom(noteid)
            Navigation.findNavController(requireView()).navigate(DetailsFragmentDirections.actionDetailsFragmentToMainFragment())
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.update_note -> {
                if (binding.tvNoteDetails.text != null && binding.tvNoteDetails.text.toString() != ""){
                    val updatedNote = Note(binding.tvNoteDetails.text.toString(),noteid)
                    viewModel.updateNoteFromRoom(updatedNote)
                    Navigation.findNavController(requireView()).navigate(DetailsFragmentDirections.actionDetailsFragmentToMainFragment())
                }else{
                    Toast.makeText(requireContext(),"Please write a note", Toast.LENGTH_LONG).show();
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }







    private fun observeLiveData() {
        viewModel.noteLiveData.observe(viewLifecycleOwner, Observer { note->
            note?.let {
                binding.tvNoteDetails.setText(note.yourNotes)
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}