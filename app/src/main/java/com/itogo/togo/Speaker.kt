package com.itogo.togo

import android.arch.persistence.room.*
import java.util.*

@Entity(tableName = "speaker")
data class Speaker(@ColumnInfo val name: String,
                   @ColumnInfo val country: String? = "Unknown",
                   @PrimaryKey val uid: String = UUID.randomUUID().toString())

@Dao
interface SpeakerDao {
    @Query("SELECT * FROM speaker")
    fun all(): List<Speaker>

    @Insert
    fun insert(speaker: Speaker)

    @Delete
    fun delete(speaker: Speaker)
}
