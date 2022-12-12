package com.github.namuan.onepagefx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("main-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 800.0, 600.0)
        HelloApplication::class.java.getResource("/styles.css")?.toExternalForm()?.let {
            scene.stylesheets.add(it)
        }
        stage.title = "OnePage"
        stage.scene = scene
        val image = Image("file-notes.png")
        stage.icons.add(image)
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}