package com.itogo.togo

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Speaker::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun speakerDao(): SpeakerDao

    companion object {
        private var SINGLETON: AppDatabase? = null

        fun instance(context: Context): AppDatabase{
            if(SINGLETON == null){
                SINGLETON = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "togoapp").build()
            }
            return SINGLETON!!
        }
    }
}
