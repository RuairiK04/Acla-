package org.androidstudio.aclai.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.androidstudio.aclai.database.ExerciseRepository
class ExerciseViewModelFactory(private val repo: ExerciseRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExerciseViewModel(repo) as T
    }
}