package com.kemalurekli.mynotes.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.kemalurekli.mynotes.model.Note
import com.kemalurekli.mynotes.service.NoteDatabase
import kotlinx.coroutines.launch

class NewNoteFragmentViewModel (application: Application) : BaseViewModel (application) {
    fun saveRoom (list: List<Note>) {

        launch {
            val dao = NoteDatabase(getApplication()).notesDao()
            val dataList = dao.insertNote(*list.toTypedArray())
        }
    }
}