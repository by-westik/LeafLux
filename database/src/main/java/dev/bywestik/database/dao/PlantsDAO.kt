package dev.bywestik.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.bywestik.database.models.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantsDAO {

    @Query("SELECT * FROM plants")
    fun getAll(): Flow<List<PlantEntity>>

    @Insert
    suspend fun insertAll(plants: List<PlantEntity>)

    @Insert
    suspend fun insertPlant(plant: PlantEntity)

    @Query("DELETE FROM plants")
    fun deleteAll()

    /*@Delete
    fun deletePlant(plant: PlantEntity)*/

}
