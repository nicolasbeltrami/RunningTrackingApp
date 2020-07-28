package com.example.runningtrackerapp.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repositories.MainRepository
import com.example.runningtrackerapp.repositories.StatisticsRepository

class StatisticsViewModel @ViewModelInject constructor(val statisticsRepository: StatisticsRepository, val mainRepository: MainRepository): ViewModel(){

    val totalTimeRun = statisticsRepository.getTotalTimeInMillis()
    val totalDistance = statisticsRepository.getTotalDistance()
    val totalCaloriesBurned = statisticsRepository.getTotalCaloriesBurned()
    val totalAvgSpeed = statisticsRepository.getTotalAvgSpeed()

    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()
}