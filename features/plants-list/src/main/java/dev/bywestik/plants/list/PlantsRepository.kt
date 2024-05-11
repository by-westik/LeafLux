package dev.bywestik.plants.list

import dev.bywestik.database.PlantsDatabase
import dev.bywestik.database.models.PlantEntity
import dev.bywestik.plants.list.utils.toPlant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlantsRepository(
    private val plantsDatabase: PlantsDatabase
) {

    fun getAll() : Flow<List<Plant>> {
        return plantsDatabase.plantsDao.getAll()
            .map { plants ->
                plants.map { plant ->
                    plant.toPlant()
                }
            }
    }

    suspend fun addPlant(plant: Plant) {
    }

}

private fun Plant.toPlantEntity(): PlantEntity {
    return PlantEntity(name = this.name, type = this.type)
}
