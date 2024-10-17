import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
fun Mod6AppFace() {
    var text by remember { mutableStateOf("Hello, Mod6AppFace World!") }
    Button(onClick = {
        text = "Hello, Mod6AppFace Desktop!"
    }) {
        Text(text)
    }
}

@Composable
@Preview
fun Mod6App() {

    MaterialTheme {
        Mod6AppFace()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Mod6App()
    }
}
