package org.androidstudio.aclai.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val password: String,
    val email: String,
    val height: Float,
    val weight: Float
)
