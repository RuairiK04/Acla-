package org.database

import android.content.Context
import androidx.room.Room
import kotlin.jvm.java

object DatabaseInstance {

    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "exercise_db"
            ).build()

            INSTANCE = instance
            instance
        }
    }
}