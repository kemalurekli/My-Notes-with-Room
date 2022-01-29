package com.kemalurekli.mynotes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kemalurekli.mynotes.model.Note

class MainFragmentViewModel : ViewModel() {

    val notes = MutableLiveData<List<Note>>()

    fun getDataFromRoom () {
        val note = Note("hello this is my first note")
        val note2 = Note("hello this is my second note")
        val note3 = Note("hello this is my third note")

        val noteList = arrayListOf<Note>(note,note2,note3)
        notes.value = noteList
    }
}