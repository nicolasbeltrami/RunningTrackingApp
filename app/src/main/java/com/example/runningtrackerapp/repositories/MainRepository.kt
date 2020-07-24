package com.example.runningtrackerapp.repositories

import com.example.runningtrackerapp.model.Run
import com.example.runningtrackerapp.model.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(private val runDao: RunDao) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSorterByDate()

    fun getAllRunsSortedByDistance() = runDao.getAllRunsSorterByDistance()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSorterByTimeInMillis()

    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSorterByAvgSpeed()

    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSorterByCaloriesBurned()

}