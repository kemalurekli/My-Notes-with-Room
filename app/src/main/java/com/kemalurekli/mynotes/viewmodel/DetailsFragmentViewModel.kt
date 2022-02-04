package com.kemalurekli.mynotes.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kemalurekli.mynotes.model.Note
import com.kemalurekli.mynotes.service.NoteDatabase
import kotlinx.coroutines.launch

class DetailsFragmentViewModel (application: Application) : BaseViewModel(application) {

    val noteLiveData = MutableLiveData<Note>()

    fun getDataFromRoom(uuid: Int) {
        launch {
            val dao = NoteDatabase(getApplication()).notesDao()
            val note = dao.getNote(uuid)
            noteLiveData.value = note
        }
    }

    fun deleteNoteFromRoom(uuid : Int) {
        launch {
            NoteDatabase(getApplication()).notesDao().deleteNote(uuid)
        }
    }
    fun updateNoteFromRoom (note: Note){
        launch {
            NoteDatabase(getApplication()).notesDao().updateNote(note)
        }
    }
}