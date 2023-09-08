package com.example.TaskManager

import android.graphics.Color
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.time.LocalDate


@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Query("SELECT * FROM Task WHERE categoryId = :categoryId")
    fun getTasksForCategory(categoryId: Int): List<Task>

    @Query("SELECT * FROM Task")
    fun getAllTasks(): List<Task>

    @Query("UPDATE Task SET done = :done WHERE id = :taskId")
    suspend fun updateTaskDoneStatus(taskId: Int, done: Boolean)

    @Query("UPDATE Task SET toDo = :newName WHERE id = :taskId")
    suspend fun updateTaskName(taskId: Int, newName: String)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM Task WHERE categoryId = :categoryId")
    suspend fun deleteTasksForCategory(categoryId: Int)


    // Add other methods
}
