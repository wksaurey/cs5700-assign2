package com.shipment_tracking_app

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

class TrackingSimulator {
    private val shipments = mutableListOf<Shipment>()

    fun addShipment(shipment: Shipment) {
        shipments.add(shipment)
    }

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }

    fun runSimulation() = runBlocking {
        launch {
            val testFilePath: String = "C:/Users/Kolter.Saurey/kolter/usu/cs5700/assignments/ShipmentTrackingSimulator/composeApp/src/desktopMain/kotlin/com/shipment_tracking_app/test.txt"
            val lines: List<String> = File(testFilePath).readLines()
            lines.forEach { line ->
                val data = line.split(",")
                val status: String = data[0]
                val shipmentId: String = data[1]
                val timestamp: String = data[2]
                val otherInfo: String? = data.getOrNull(3)
                println("Status : $status")
                println("Shipment ID : $shipmentId")
                println("Timestamp : $timestamp")
                println("OtherInfo : $otherInfo")
                ShippingUpdate(status = status, shipmentId = shipmentId, timestamp = timestamp, otherInfo = otherInfo)
                delay(1000L)
            }
        }
    }
}