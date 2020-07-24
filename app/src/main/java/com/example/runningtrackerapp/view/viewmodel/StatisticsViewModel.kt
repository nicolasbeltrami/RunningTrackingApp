package com.example.runningtrackerapp.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repositories.StatisticsRepository

class StatisticsViewModel @ViewModelInject constructor(val statisticsRepository: StatisticsRepository): ViewModel(){

}