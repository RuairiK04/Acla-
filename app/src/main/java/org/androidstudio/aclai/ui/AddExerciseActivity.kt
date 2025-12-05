package org.androidstudio.aclai.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.androidstudio.aclai.database.ExerciseRepository
import org.androidstudio.aclai.database.models.Exercise
import org.androidstudio.aclai.ui.viewmodels.ExerciseViewModel
import org.database.DatabaseInstance
import org.androidstudio.aclai.ui.viewmodels.ExerciseViewModelFactory
import org.androidstudio.aclai.R


class AddExerciseActivity : AppCompatActivity() {

    private val viewModel: ExerciseViewModel by viewModels {
        val dao = DatabaseInstance.getDatabase(this).exerciseDao()
        val repo = ExerciseRepository(dao)
        ExerciseViewModelFactory(repo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exercise)

        val name = findViewById<EditText>(R.id.inputName)
        val sets = findViewById<EditText>(R.id.inputSets)
        val reps = findViewById<EditText>(R.id.inputReps)
        val weight = findViewById<EditText>(R.id.inputWeight)
        val saveBtn = findViewById<Button>(R.id.btnSave)

        saveBtn.setOnClickListener {
            val exercise = Exercise(
                name = name.text.toString(),
                sets = sets.text.toString().toInt(),
                reps = reps.text.toString().toInt(),
                weight = weight.text.toString().toDouble(),
                date = System.currentTimeMillis()
            )

            viewModel.addExercise(exercise)
            finish()
        }
    }
}