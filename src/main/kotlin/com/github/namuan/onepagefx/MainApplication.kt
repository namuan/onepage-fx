package com.github.namuan.onepagefx

import javafx.application.Application
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        OnePageScreen("OnePage").setup(stage)
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}