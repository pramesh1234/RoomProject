package com.famco.roomproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amphibian_table")
data class AmphibianModel(val amphibianName: String, val amphibianSpecies: String) {
    @PrimaryKey(autoGenerate = true)
    var amphibianId: Int = 0
}