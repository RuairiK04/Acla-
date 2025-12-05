package org.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.androidstudio.aclai.database.models.Exercise
import org.androidstudio.aclai.R

class ExerciseAdapter(
    private var exercises: List<Exercise>
) : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val name: TextView = item.findViewById(R.id.rowName)
        val details: TextView = item.findViewById(R.id.rowDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val ex = exercises[position]
        holder.name.text = ex.name
        holder.details.text = "${ex.sets}× sets, ${ex.reps} reps, ${ex.weight} kg"
    }

    override fun getItemCount(): Int = exercises.size

    fun update(list: List<Exercise>) {
        this.exercises = list
        notifyDataSetChanged()
    }
}