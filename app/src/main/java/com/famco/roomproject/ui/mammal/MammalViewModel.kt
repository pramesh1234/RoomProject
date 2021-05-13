package com.famco.roomproject.ui.mammal

import android.app.Application
import androidx.lifecycle.*
import com.famco.roomproject.database.AnimalDatabase
import com.famco.roomproject.model.MammalModel
import com.famco.roomproject.repository.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MammalViewModel(application: Application) : AndroidViewModel(application) {
    val allMammals: LiveData<List<MammalModel>>
    val repository: AnimalRepository

    init {
        val dao = AnimalDatabase.getDatabase(application).animalDao()
        repository = AnimalRepository(dao)
        allMammals = repository.allMammal
    }

    fun deleteMammal(mammalModel: MammalModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteMammal(mammalModel)
    }


}
