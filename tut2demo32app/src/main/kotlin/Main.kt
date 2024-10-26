import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.tut2demo32mod5.Mod5AppFace
import com.example.tut2demo32mod6.Mod6AppFace

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Column(
            modifier = Modifier.padding(10.dp)
                .background(Color.LightGray)
                .verticalScroll(rememberScrollState())
        ) {
            // the Column modifier can add a ".size(400.dp)" line

            Row {
                Text("---- ----")
            }
            Row {
                Button(onClick = {
                    text = "Hello, Desktop!"
                }) {
                    Text(text)
                }
            }
            Row {
                Mod5AppFace()
            }
            Row {
                Mod6AppFace()
            }
            Row {
                Text("---- ----")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
