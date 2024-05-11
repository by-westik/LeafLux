package dev.bywestik.leaflux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.bywestik.database.PlantsDatabase
import dev.bywestik.leaflux.ui.theme.LeafLuxTheme
import dev.bywestik.plants.list.PlantsListViewModel
import dev.bywestik.plants.list.PlantsRepository
import dev.bywestik.plants.list.ui.PlantListScreen

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<PlantsListViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val db = PlantsDatabase(applicationContext)
                    return PlantsListViewModel(
                        plantsRepository = PlantsRepository(db)
                    ) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            LeafLuxTheme {
                PlantListScreen(viewModel)
            }
        }
    }
}





