package com.shipment_tracking_app

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.sql.Time

object TrackingSimulator {
    private val shipments = mutableListOf<Shipment>()

    fun addShipment(shipment: Shipment) {
        shipments.add(shipment)
    }

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }

    suspend fun runSimulation() {
        delay(5000L)
        val testFilePath: String = "C:/Users/Kolter.Saurey/kolter/usu/cs5700/assignments/ShipmentTrackingSimulator/composeApp/src/desktopMain/kotlin/com/shipment_tracking_app/test.txt"
        val lines: List<String> = File(testFilePath).readLines()
        lines.forEach { line ->
            delay(1000L)
            val data = line.split(",")
            val status: String = data[0]
            val shipmentId: String = data[1]
            val timestamp: String = data[2]
            val otherInfo: String? = data.getOrNull(3)
            val updateStrategy: ShipmentUpdateStrategy = getUpdateStrategy(status)
            ShippingUpdate(status, shipmentId, timestamp, otherInfo, updateStrategy).updateShipment()
            println("Shipment $shipmentId updated to $status")
        }
        println("Simulation completed")
    }

    private fun getUpdateStrategy(status: String): ShipmentUpdateStrategy {
        return when (status) {
            "created" -> CreatedUpdateStrategy()
            "shipped" -> TimeUpdateStrategy()
            "location" -> LocationUpdateStrategy()
            "delivered" -> StatusUpdateStrategy()
            "delayed" -> TimeUpdateStrategy()
            "lost" -> StatusUpdateStrategy()
            "canceled" -> StatusUpdateStrategy()
            "noteadded" -> NoteAddedUpdateStrategy()
            else -> throw IllegalArgumentException("Unknown status: $status")
        }
    }
}