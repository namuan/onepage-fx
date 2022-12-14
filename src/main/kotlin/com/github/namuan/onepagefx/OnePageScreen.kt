package com.github.namuan.onepagefx

import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage

class OnePageScreen(private val title: String) {
    fun setup(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("onepage-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 800.0, 600.0)
        HelloApplication::class.java.getResource("/styles.css")?.toExternalForm()?.let {
            scene.stylesheets.add(it)
        }
        stage.title = title
        stage.scene = scene
        val image = Image("file-notes.png")
        stage.icons.add(image)

        loadPosition(stage)

        stage.setOnCloseRequest { _ ->
            savePosition(stage)
        }
    }
}