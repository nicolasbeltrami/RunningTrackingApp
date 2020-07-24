package com.example.runningtrackerapp.repositories

import com.example.runningtrackerapp.model.RunDao
import javax.inject.Inject

class StatisticsRepository @Inject constructor(private val runDao: RunDao) {

    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()

    fun getTotalDistance() = runDao.getTotalDistance()

    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

}