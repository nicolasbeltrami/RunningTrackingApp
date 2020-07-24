package com.example.runningtrackerapp.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repositories.MainRepository
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(val mainRepository: MainRepository): ViewModel() {
}