package com.famco.roomproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.famco.roomproject.database.AnimalDatabase
import com.famco.roomproject.model.ReptileModel
import com.famco.roomproject.repository.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddReptileViewModel(application: Application) : AndroidViewModel(application) {
    private val allReptile: LiveData<List<ReptileModel>>
    private val repository: AnimalRepository

    init {
        val dao = AnimalDatabase.getDatabase(application).animalDao()
        repository = AnimalRepository(dao)
        allReptile = repository.allAnimals
    }
    fun insertAnimal(reptileModel: ReptileModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(reptileModel)
    }
}