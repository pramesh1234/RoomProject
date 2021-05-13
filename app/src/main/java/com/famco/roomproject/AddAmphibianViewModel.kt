package com.famco.roomproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.famco.roomproject.database.AnimalDatabase
import com.famco.roomproject.model.AmphibianModel
import com.famco.roomproject.model.MammalModel
import com.famco.roomproject.repository.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddAmphibianViewModel(application: Application) : AndroidViewModel(application) {
    private val allAmphibian: LiveData<List<AmphibianModel>>
    private val repository: AnimalRepository

    init {
        val dao = AnimalDatabase.getDatabase(application).animalDao()
        repository = AnimalRepository(dao)
        allAmphibian = repository.allAmphibian
    }
    fun insertAmphibian(amphibianModel: AmphibianModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertAmphibian(amphibianModel)
    }
}