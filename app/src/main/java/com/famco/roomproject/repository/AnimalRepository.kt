package com.famco.roomproject.repository

import androidx.lifecycle.LiveData
import com.famco.roomproject.model.ReptileModel
import com.famco.roomproject.interfaces.AnimalDao
import com.famco.roomproject.model.AmphibianModel
import com.famco.roomproject.model.MammalModel

class AnimalRepository(private val animalDao: AnimalDao) {
    val allAnimals:LiveData<List<ReptileModel>> = animalDao.getAnimalList()
    val allMammal:LiveData<List<MammalModel>> = animalDao.getMammalList()
    val allAmphibian:LiveData<List<AmphibianModel>> = animalDao.getAmphibianList()

    suspend fun insert(reptileModel: ReptileModel){
        animalDao.insert(reptileModel)
    }
    suspend fun delete(reptileModel: ReptileModel){
        animalDao.delete(reptileModel)
    }
    suspend fun insertMammal(mammalModel: MammalModel){
        animalDao.insertMammal(mammalModel)
    }
    suspend fun deleteMammal(mammalModel: MammalModel){
        animalDao.deleteMammal(mammalModel)
    }
    suspend fun insertAmphibian(amphibianModel: AmphibianModel){
        animalDao.insertAmphibian(amphibianModel)
    }
    suspend fun deleteAmphibian(amphibianModel: AmphibianModel){
        animalDao.deleteAmphibian(amphibianModel)
    }
}