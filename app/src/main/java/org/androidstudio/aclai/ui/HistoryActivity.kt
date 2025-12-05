package org.androidstudio.aclai.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.androidstudio.aclai.ui.adapters.ExerciseAdapter
import org.androidstudio.aclai.ui.viewmodels.ExerciseViewModel
import org.androidstudio.aclai.database.DatabaseInstance
import org.androidstudio.aclai.database.ExerciseRepository
import org.androidstudio.aclai.ui.viewmodels.ExerciseViewModelFactory
import com.example.acla.R

class HistoryActivity : AppCompatActivity() {

    private lateinit var adapter: ExerciseAdapter

    private val viewModel: ExerciseViewModel by viewModels {
        val dao = DatabaseInstance.getDatabase(this).exerciseDao()
        ExerciseRepositoryFactory(ExerciseRepository(dao))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val recycler = findViewById<RecyclerView>(R.id.recyclerHistory)
        recycler.layoutManager = LinearLayoutManager(this)

        adapter = ExerciseAdapter(listOf())
        recycler.adapter = adapter

        viewModel.exercises.observe(this) { list ->
            adapter.update(list)
        }

        viewModel.loadExercises()
    }
}