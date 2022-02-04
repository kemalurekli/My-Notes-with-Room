package com.kemalurekli.mynotes.service

import androidx.room.*
import com.kemalurekli.mynotes.model.Note

@Dao
interface NotesDao {
    @Insert()
    suspend fun insertNote(vararg note : Note) : List<Long>

    @Query("SELECT * FROM note")
    suspend fun getAllNotes () :List<Note>

    @Query("SELECT * FROM note WHERE uuid = :noteId" )
    suspend fun getNote (noteId : Int) : Note

    @Query("DELETE FROM note WHERE uuid = :noteId")
    suspend fun deleteNote (noteId : Int)

    @Update()
    suspend fun updateNote (note : Note)
}