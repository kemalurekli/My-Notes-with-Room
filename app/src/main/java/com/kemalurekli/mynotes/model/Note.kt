package com.kemalurekli.mynotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(
    @ColumnInfo(name="yourNotes")
    val yourNotes : String?,
    @ColumnInfo(name = "creationDate")
    var creationDate: Date = Date(System.currentTimeMillis()),

    @PrimaryKey(autoGenerate = true)
    val uuid: Int = 0

)
