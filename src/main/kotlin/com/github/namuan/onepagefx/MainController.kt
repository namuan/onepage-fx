package com.github.namuan.onepagefx

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.input.KeyEvent
import java.io.File

class MainController {
    @FXML
    private lateinit var notesTextArea: TextArea

    fun onKeyPressed(keyEvent: KeyEvent) {
        val notes = notesTextArea.text
        val applicationDirectory = System.getProperty("user.home") + "/.onepagefx"
        val file = File(applicationDirectory, "notes.txt")
        file.parentFile.mkdirs()
        file.writeText(notes)
    }
}