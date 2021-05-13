package com.famco.roomproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.famco.roomproject.model.ReptileModel
import com.famco.roomproject.interfaces.AnimalDao
import com.famco.roomproject.model.AmphibianModel
import com.famco.roomproject.model.MammalModel

@Database(entities = arrayOf(ReptileModel::class,MammalModel::class,AmphibianModel::class),version = 2,exportSchema = false)
public abstract class AnimalDatabase : RoomDatabase() {

    abstract fun animalDao() : AnimalDao
    companion object {
        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun getDatabase(context: Context): AnimalDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalDatabase::class.java,
                    "animal_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}