package com.github.gnusin_pavel

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.github.gnusin_pavel.dialogs.FileDialog

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    Window(
        title = "Simple CSV Editor",
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(width = 1024.dp, height = 768.dp)
    ) {
        App()
        FileDialog("Открыть файл", true) {
            println(it)
        }
        MenuBar {
            Menu("Файл") {
                Item("Открыть файл") {

                }
                Item("Сохранить") {

                }
                Separator()
                Item("Закрыть") {
                    exitApplication()
                }
            }
        }
    }
}
