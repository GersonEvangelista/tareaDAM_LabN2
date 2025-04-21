package gerson.dev.labn2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable

fun calculadoraPropina() {
    var montoCuentaTXT by remember { mutableStateOf("") }
    var porcentajePropina: Int by remember { mutableStateOf(0) }
    var propinaTXT by remember { mutableStateOf("") }
    var totalTXT by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 28.dp).padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Calculadora de Propina",
            modifier = Modifier.padding(bottom = 10.dp)
        )

        TextField(
            value = montoCuentaTXT,
            onValueChange = { montoCuentaTXT = it },
            label = { Text("Monto en soles") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Box() {
            Text(text = "Porcentaje de propina: " + porcentajePropina + "%")

            Slider(
                value = porcentajePropina.toFloat(),
                onValueChange = { porcentajePropina = it.toInt() },
                valueRange = 0f..100f,
                steps = 100,
                modifier = Modifier.padding(horizontal = 16.dp).padding(top = 36.dp)

            )
        }

        Spacer(modifier = Modifier.padding(2.dp))

        Button(
            onClick = {
                if (montoCuentaTXT.isNotEmpty()) {
                    val montoCuenta = montoCuentaTXT.toDouble()
                    val propina = montoCuenta * (porcentajePropina.toDouble() / 100)
                    val total = montoCuenta + propina
                    propinaTXT = "%.2f".format(propina)
                    totalTXT = "%.2f".format(total)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color.Blue)
        ){
            Text(text = "Calcular")
        }

        Text(text = "Monto total en soles: $totalTXT")
    }
}