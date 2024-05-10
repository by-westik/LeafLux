package dev.bywestik.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.bywestik.database.models.PlantEntity

@Dao
interface PlantsDAO {

    @Query("SELECT * from plants")
    fun getAll(): List<PlantEntity>

    @Insert
    fun insetAll(plants: List<PlantEntity>)

    @Insert
    fun insertPlan(plant: PlantEntity)

 /*   @Delete
    fun deleteAll()

    @Delete
    fun deletePlant(plant: PlantEntity)*/

}
