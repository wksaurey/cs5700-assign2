package com.shipment_tracking_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ShipmentTrackingSimulator",
    ) {
        App()
    }
}