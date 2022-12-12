package com.github.namuan.onepagefx

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.input.KeyEvent
import java.io.File

class MainController {
    private val applicationDirectory: String = System.getProperty("user.home") + "/.onepagefx"
    private val file: File = File(applicationDirectory, "notes.txt")

    @FXML
    private lateinit var notesTextArea: TextArea

    fun initialize() {
        file.parentFile.mkdirs()

        if (file.exists()) {
            notesTextArea.text = file.readText()

            // place cursor at the end of the text
            notesTextArea.positionCaret(notesTextArea.text.length)
        }
    }

    fun onKeyPressed(keyEvent: KeyEvent) {
        val notes = notesTextArea.text
        file.writeText(notes)
    }
}