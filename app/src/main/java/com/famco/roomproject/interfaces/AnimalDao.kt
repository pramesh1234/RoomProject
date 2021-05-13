package com.famco.roomproject.interfaces
import androidx.lifecycle.LiveData
import androidx.room.*
import com.famco.roomproject.model.AmphibianModel
import com.famco.roomproject.model.ReptileModel
import com.famco.roomproject.model.MammalModel

@Dao
interface AnimalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(reptileModel: ReptileModel)

    @Delete
    suspend fun delete(reptileModel: ReptileModel)

    @Query("Select * from reptile_table order by reptileId ASC")
    fun getAnimalList():LiveData<List<ReptileModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMammal(mammalModel: MammalModel)

    @Delete
    suspend fun deleteMammal(mammalModel: MammalModel)

    @Query("Select * from mammal_table order by mammalId ASC")
    fun getMammalList():LiveData<List<MammalModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAmphibian(amphibianModel: AmphibianModel)

    @Delete
    suspend fun deleteAmphibian(amphibianModel: AmphibianModel)

    @Query("Select * from amphibian_table order by amphibianId ASC")
    fun getAmphibianList():LiveData<List<AmphibianModel>>
}