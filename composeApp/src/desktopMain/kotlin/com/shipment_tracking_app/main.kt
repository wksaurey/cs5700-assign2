package com.shipment_tracking_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.nio.file.Paths
import javax.sound.midi.Track

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ShipmentTrackingSimulator",
        alwaysOnTop = true
    ) {
        App()
        TrackingSimulator.runSimulation()
    }
}