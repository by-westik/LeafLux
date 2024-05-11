package dev.bywestik.plants.list.utils

import dev.bywestik.database.models.PlantEntity
import dev.bywestik.plants.list.Plant
import dev.bywestik.plants.list.PlantUI
import dev.bywestik.plants.list.State

internal fun PlantEntity.toPlant(): Plant {
    return Plant(
        id = this.id,
        name = this.name,
        type = this.type
    )
}

internal fun Plant.toPlantUI(): PlantUI {
    return PlantUI(
        id = this.id,
        name = this.name,
        type = this.type,
    )
}

internal fun List<Plant>.toState(): State {
    return if (this.isEmpty()) {
        State.None
    } else {
        val listUi = this.map {
            it.toPlantUI()
        }
        return State.Success(listUi)
    }
}
