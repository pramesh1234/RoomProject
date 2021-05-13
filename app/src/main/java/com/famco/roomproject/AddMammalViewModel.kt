package com.famco.roomproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.famco.roomproject.database.AnimalDatabase
import com.famco.roomproject.model.MammalModel
import com.famco.roomproject.repository.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMammalViewModel(application: Application) : AndroidViewModel(application) {
    private val allMammal: LiveData<List<MammalModel>>
    private val repository: AnimalRepository

    init {
        val dao = AnimalDatabase.getDatabase(application).animalDao()
        repository = AnimalRepository(dao)
        allMammal = repository.allMammal
    }
    fun insertMammal(mammalModel: MammalModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertMammal(mammalModel)
    }
}