package dev.bywestik.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.bywestik.database.dao.PlantsDAO
import dev.bywestik.database.models.PlantEntity

@Database(entities = [PlantEntity::class], version = 1)
abstract class PlantsDatabase : RoomDatabase() {

    abstract val plantsDao: PlantsDAO

}

fun PlantsDatabase(applicationContext: Context) = Room.databaseBuilder(
    checkNotNull(applicationContext.applicationContext),
    PlantsDatabase::class.java,
    "plants",
).build()