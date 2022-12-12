package com.github.namuan.onepagefx

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.input.KeyEvent
import java.io.File

class MainController {
    private val applicationDirectory = System.getProperty("user.home") + "/.onepagefx"
    val file = File(applicationDirectory, "notes.txt")

    @FXML
    private lateinit var notesTextArea: TextArea

    // create the application directory if it doesn't exist
    fun initialize() {
        file.parentFile.mkdirs()
    }

    fun onKeyPressed(keyEvent: KeyEvent) {
        val notes = notesTextArea.text
        file.writeText(notes)
    }
}