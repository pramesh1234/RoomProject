package com.famco.roomproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mammal_table")
data class MammalModel(val mammalName:String, val mammalSpecies:String){
    @PrimaryKey(autoGenerate = true) var mammalId:Int=0
}
