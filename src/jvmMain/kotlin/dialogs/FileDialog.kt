package com.github.gnusin_pavel.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.AwtWindow
import androidx.compose.ui.window.FrameWindowScope
import java.awt.FileDialog
import java.nio.file.Path
import java.nio.file.Paths

@Composable
fun FrameWindowScope.FileDialog(
    title: String,
    isLoad: Boolean,
    onResult: (result: Path?) -> Unit
) = AwtWindow(
    create = {
        object : FileDialog(window, "Выберите файл", if (isLoad) LOAD else SAVE) {
            override fun setVisible(visible: Boolean) {
                super.setVisible(visible)

                if (visible) {
                    if (file != null) {
                        onResult(Paths.get(directory).resolve(file))
                    } else {
                        onResult(null)
                    }
                }
            }
        }.apply {
            this.title = title
        }
    },

    dispose = FileDialog::dispose
)