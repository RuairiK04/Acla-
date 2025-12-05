package org.androidstudio.aclai.database

// BirdDao.kt
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.androidstudio.aclai.database.models.Exercise

@Dao
interface ExerciseDao {
    @insert
    suspend fun insertExercise(exercise: Exercise)

    @Query("SELECT * FROM Exercise WHERE id = :id")
    suspend fun getAllExercises(): List<Exercise>
}