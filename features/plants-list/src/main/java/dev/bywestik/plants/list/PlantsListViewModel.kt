package dev.bywestik.plants.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bywestik.plants.list.utils.toPlantUI
import dev.bywestik.plants.list.utils.toState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlantsListViewModel(
    private val plantsRepository: PlantsRepository
) : ViewModel() {
    val state: StateFlow<State>
        get() = plantsRepository.getAll()
            .map {
                it.toState()
            }
            .stateIn(viewModelScope, SharingStarted.Lazily, State.None)


    fun addPlant() {
        val plant = Plant(1, "232", "3434")
        viewModelScope.launch {
            plantsRepository.addPlant(plant = plant)
        }
    }
}

sealed class State() {
    object None: State()
    class Success(val data: List<PlantUI>): State()
}