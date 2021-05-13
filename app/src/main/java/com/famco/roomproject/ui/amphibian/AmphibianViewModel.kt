package com.famco.roomproject.ui.amphibian

import android.app.Application
import androidx.lifecycle.*
import com.famco.roomproject.database.AnimalDatabase
import com.famco.roomproject.model.AmphibianModel
import com.famco.roomproject.repository.AnimalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AmphibianViewModel (application: Application) : AndroidViewModel(application) {
    val allAmphibian: LiveData<List<AmphibianModel>>
    val repository: AnimalRepository

    init {
        val dao = AnimalDatabase.getDatabase(application).animalDao()
        repository = AnimalRepository(dao)
        allAmphibian = repository.allAmphibian
    }

    fun deleteAmphibian(amphibianModel: AmphibianModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAmphibian(amphibianModel)
    }


}