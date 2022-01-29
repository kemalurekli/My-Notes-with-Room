package com.kemalurekli.mynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kemalurekli.mynotes.R
import com.kemalurekli.mynotes.databinding.ItemNoteBinding
import com.kemalurekli.mynotes.model.Note
import java.util.ArrayList

class NoteAdapter(val noteList : ArrayList<Note>)
    :RecyclerView.Adapter<NoteAdapter.RowLayoutDesign>() {

    class RowLayoutDesign(val rowLayoutBinding: ItemNoteBinding)
        :RecyclerView.ViewHolder(rowLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowLayoutDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowLayoutBinding = ItemNoteBinding.inflate(layoutInflater, parent, false)
        return RowLayoutDesign(rowLayoutBinding)
    }

    override fun onBindViewHolder(holder: RowLayoutDesign, position: Int) {
        val note = noteList[position]

        holder.rowLayoutBinding.apply {
            tvNote.text = note.yourNotes
            tvId.text = note.uuid.toString()
        }
    }

    override fun getItemCount(): Int {

        return noteList.size
    }

    fun updateNoteList(newNoteList: List<Note>) {
        noteList.clear()
        noteList.addAll(newNoteList)
        notifyDataSetChanged()
    }
}