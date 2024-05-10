package dev.bywestik.plants.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlantsList(
    plants: List<PlantUI> = plants()
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
    ) {
        items(plants) {plant ->
            PlantItem(plant)
        }
    }
}


@Composable
@Preview
fun PlantItem(
    @PreviewParameter(PlantUIPreview::class) plantUI: PlantUI
) {
    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = plantUI.name,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 4.dp),
                )
            Text(
                text = plantUI.type,
                fontSize = 12.sp,
            )
        }
    }
}

class PlantUIPreview: PreviewParameterProvider<PlantUI> {
    override val values: Sequence<PlantUI>
        get() = sequenceOf(PlantUI(1, "Аркадий", "Кактус"))
}

fun plants(): List<PlantUI> {
    return listOf(
        PlantUI(1, "Аркадий", "Кактус"),
        PlantUI(2, "Геннадий", "Сосна"),
        PlantUI(3, "Борис", "Кактус"),
        PlantUI(4, "Палтос", "Томат"),
        PlantUI(5, "Арамис", "Акация"),
        PlantUI(6, "Валерий", "Кактус"),
        PlantUI(7, "Кристина", "Акация"),
        PlantUI(8, "Маруся", "Суккулент"),
        PlantUI(9, "Аркадий", "Кактус"),
        PlantUI(10, "Геннадий", "Сосна"),
        PlantUI(11, "Борис", "Кактус"),
        PlantUI(12, "Палтос", "Томат"),
        PlantUI(13, "Арамис", "Акация"),
        PlantUI(14, "Валерий", "Кактус"),
        PlantUI(15, "Кристина", "Акация"),
        PlantUI(16, "Маруся", "Суккулент"),
        PlantUI(17, "Аркадий", "Кактус"),
        PlantUI(18, "Геннадий", "Сосна"),
        PlantUI(19, "Борис", "Кактус"),
        PlantUI(20, "Палтос", "Томат"),
        PlantUI(21, "Арамис", "Акация"),
        PlantUI(22, "Валерий", "Кактус"),
        PlantUI(23, "Кристина", "Акация"),
        PlantUI(24, "Маруся", "Суккулент"),    )
}



