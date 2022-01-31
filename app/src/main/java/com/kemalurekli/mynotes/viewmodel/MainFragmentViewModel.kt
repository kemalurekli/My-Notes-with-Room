package com.kemalurekli.mynotes.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kemalurekli.mynotes.model.Note
import com.kemalurekli.mynotes.service.NoteDatabase
import kotlinx.coroutines.launch

class MainFragmentViewModel (application: Application) : BaseViewModel(application) {

    val notes = MutableLiveData<List<Note>>()

/*    fun getDataFromRoom () {
        val note = Note("hello this is my first note")
        val note2 = Note("hello this is my second note")
        val note3 = Note("hello this is my third note")

        val noteList = arrayListOf<Note>(note,note2,note3)
        notes.value = noteList
    }*/

     fun getDataFromSQLite() {
        launch {
            val notes = NoteDatabase(getApplication()).notesDao().getAllNotes()
            showNotes(notes)
            Toast.makeText(getApplication(),"Note From SQLite",Toast.LENGTH_LONG).show()
        }
    }

    private fun showNotes(noteList: List<Note>) {
        notes.value = noteList

    }

}