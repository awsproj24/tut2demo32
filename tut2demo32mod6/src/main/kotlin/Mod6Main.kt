
package com.example.tut2demo32mod6

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import kotlinx.coroutines.withContext


@Composable
fun Mod6AppFace() {
    var text by remember { mutableStateOf("Hello, Mod6AppFace World!") }
    val ktorHttpScope = rememberCoroutineScope()

    Button(onClick = {
        text = "Hello, Mod6AppFace Desktop!"
        ktorHttpScope.launch {
            //medium.com  kevin_be_gray make-threaded-http-requests-in-kotlin
            // it runs runBlocking that's not suitable here.
            // we change it to a dispatcher switching.
            withContext(Dispatchers.IO) {
                delay(java.time.Duration.ofMillis(1000L))

                val a = async {
                    println("check 6")
                    6
                }
                val b = async { 7 }

                val tm1: Long = System.currentTimeMillis()
                val client = HttpClient(CIO)
                val response: HttpResponse =
                    client.get("https://us-central1-project-tahiti-346023.cloudfunctions.net/official-word")
                val tm2: Long = System.currentTimeMillis()

                text += "\n  async val " + (a.await() + b.await()).toString()
                text += "\n  status " + response.status
                text += "\n  cost millis " + (tm2 - tm1).toString()
                text += "\n  response body " + response.toString()
            }
        }
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
