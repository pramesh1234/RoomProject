package com.famco.roomproject.ui.reptile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.famco.roomproject.database.AnimalDatabase
import com.famco.roomproject.model.ReptileModel
import com.famco.roomproject.repository.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReptileViewModel(application: Application) : AndroidViewModel(application) {
     val allReptile: LiveData<List<ReptileModel>>
     val repository: AnimalRepository

    init {
        val dao = AnimalDatabase.getDatabase(application).animalDao()
        repository = AnimalRepository(dao)
        allReptile = repository.allAnimals
    }

    fun deleteAnimal(reptileModel: ReptileModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(reptileModel)
    }


}
