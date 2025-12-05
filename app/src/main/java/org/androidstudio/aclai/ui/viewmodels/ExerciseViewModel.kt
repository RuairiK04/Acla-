package org.androidstudio.aclai.ui.viewmodels

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.androidstudio.aclai.database.ExerciseRepository
import org.androidstudio.aclai.database.models.Exercise

class ExerciseViewModel(private val repo: ExerciseRepository) : ViewModel() {

    fun addExercise(exercise: Exercise) {
        viewModelScope.launch {
            repo.addExercise(exercise)
        }
    }

    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> get() = _exercises

    fun loadExercises() {
        viewModelScope.launch {
            _exercises.value = repo.getAllExercises()
        }
    }
}