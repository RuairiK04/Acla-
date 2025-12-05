package org.androidstudio.aclai.database
class ExerciseRepository(private val dao: ExerciseDao) {

    suspend fun addExercise(exercise: Exercise) = dao.insertExercise(exercise)

    suspend fun getAllExercises() = dao.getAllExercises()
}