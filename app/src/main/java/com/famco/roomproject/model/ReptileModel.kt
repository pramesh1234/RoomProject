package com.famco.roomproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reptile_table")
data class ReptileModel(val reptileName:String, val reptileSpecies:String){
    @PrimaryKey(autoGenerate = true) var reptileId:Int=0
}
