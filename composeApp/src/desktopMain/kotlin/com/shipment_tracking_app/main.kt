package com.shipment_tracking_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.nio.file.Paths
import javax.sound.midi.Track

fun main() = runBlocking {
    launch { TrackingSimulator.runSimulation() }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "ShipmentTrackingSimulator",
            alwaysOnTop = true
        ) {
            App()
        }
    }
}