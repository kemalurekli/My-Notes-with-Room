package com.kemalurekli.mynotes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kemalurekli.mynotes.databinding.FragmentDetailsBinding
import com.kemalurekli.mynotes.viewmodel.DetailsFragmentViewModel
import com.kemalurekli.mynotes.viewmodel.NewNoteFragmentViewModel

class DetailsFragment : Fragment() {
    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : DetailsFragmentViewModel
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}